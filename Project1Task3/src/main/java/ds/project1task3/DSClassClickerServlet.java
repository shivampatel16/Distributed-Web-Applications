/**
 * Author: Shivam Patel
 * Andrew ID: shpatel
 * Last Modified: September 23, 2022
 * File: DSClassClickerServlet.java
 * Part Of: Project1Task3
 *
 * This Java file acts as a Servlet (Controller) for this program.
 * It initially gets the answer selected by the user in index.jsp,
 * increments its count using Model function and prompts the user to
 * select another answer in futureClicker.jsp. The user can continue
 * selecting as many answers as he wants. However, once the
 * /getResults url pattern is invoked, the count of the answers by the
 * class are posted using results.jsp.
 *
 * The counts of the answers are stored in a Sorted Map in Model and once
 * the /getResults url pattern is invoked, the Servlet displays the count
 * in results.jsp. However, if the map storing the count is empty, a
 * corresponding message would be displayed.
 *
 * The Servlet is also programmed to be compatible with different types of dives.
 */

// Defining the package for this file
package ds.project1task3;

// Imports necessary for handling HttpServlet requests, exceptions and annotation
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "dsClassClickerServlet", urlPatterns = {"/getInitialClicker", "/getFutureClicker", "/getResults"})
public class DSClassClickerServlet extends HttpServlet {

    // Creating an object for the model
    DSClassClickerModel model = new DSClassClickerModel();

    /***
     * This servlet will reply to HTTP POST requests via this doPost method
     * Handles urlPatterns = {"/getInitialClicker", "/getFutureClicker"}
     * @param request Represents the request from HttpServletRequest
     * @param response Represents the response from HttpServletRequest
     * @throws IOException Exception during IO operations
     * @throws ServletException Represents servlet exceptions
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // Source: CMU 95702 Fall 2022 Lab2-InterestingPicture Code
        // Used for compatability of the code on different devices

        // Determine what type of device our user is
        String ua = request.getHeader("User-Agent");

        // prepare the appropriate DOCTYPE for the view pages
        if (ua != null && ((ua.indexOf("Android") != -1) || (ua.indexOf("iPhone") != -1))) {
            /*
             * This is the latest XHTML Mobile doctype. To see the difference it
             * makes, comment it out so that a default desktop doctype is used
             * and view on an Android or iPhone.
             */
            request.setAttribute("doctype", "<!DOCTYPE html PUBLIC \"-//WAPFORUM//DTD XHTML Mobile 1.2//EN\" \"http://www.openmobilealliance.org/tech/DTD/xhtml-mobile12.dtd\">");
        } else {
            request.setAttribute("doctype", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
        }

        // Get and store the answer selected by the user in the current round
        String answer = request.getParameter("answer");

        // Add the answer to the Sorted Map to increment its could by 1 in the
        // Sorted Map that is storing the counts of each answer
        model.incrementAnswerCount(answer);

        // Set attributes for futureClicker.jsp file
        // The attribute set is the selected answer by the user in the current round
        request.setAttribute("selectedAnswer", answer);

        // Set the next View to be output.jsp displaying the scrapped information
        RequestDispatcher view = request.getRequestDispatcher("futureClicker.jsp");

        // Forwards HttpServletRequest request, HttpServletResponse response to the View
        view.forward(request, response);
    }

    /***
     * This servlet will reply to HTTP GET requests via this doGet method
     * urlPatterns = {"/getResults"}
     * @param request Represents the request from HttpServletRequest
     * @param response Represents the response from HttpServletRequest
     * @throws IOException Exception during IO operations
     * @throws ServletException Represents servlet exceptions
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // Gets and store the HTML formatted output to be presented on results.jsp
        String results = model.getResultCount();

        // Reset the Sorted Map storing the count of answers
        // This is done because the /getResults url pattern was invoked
        model.resetResults();

        // Source: CMU 95702 Fall 2022 Lab2-InterestingPicture Code
        // Used for compatability of the code on different devices

        // Determine what type of device our user is
        String ua = request.getHeader("User-Agent");

        // Prepare the appropriate DOCTYPE for the view pages
        if (ua != null && ((ua.indexOf("Android") != -1) || (ua.indexOf("iPhone") != -1))) {
            /*
             * This is the latest XHTML Mobile doctype. To see the difference it
             * makes, comment it out so that a default desktop doctype is used
             * and view on an Android or iPhone.
             */
            request.setAttribute("doctype", "<!DOCTYPE html PUBLIC \"-//WAPFORUM//DTD XHTML Mobile 1.2//EN\" \"http://www.openmobilealliance.org/tech/DTD/xhtml-mobile12.dtd\">");
        } else {
            request.setAttribute("doctype", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
        }

        // Set attributes for results.jsp file
        request.setAttribute("results", results);

        // Set the next View to be output.jsp displaying the scrapped information
        RequestDispatcher view = request.getRequestDispatcher("results.jsp");

        // Forwards HttpServletRequest request, HttpServletResponse response to the View
        view.forward(request, response);
    }
}
