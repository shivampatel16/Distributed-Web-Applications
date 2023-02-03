/**
 * Author: Shivam Patel
 * Andrew ID: shpatel
 * Last Modified: September 23, 2022
 * File: StateInformationServlet.java
 * Part Of: Project1Task2
 *
 * This Java file acts as a Servlet (Controller) for this program.
 * It gets the name of a US State from the user, passes the name
 * of that US State to the Model. The Model then scrapes information
 * about the US State from various sites and sends it back to the Servlet.
 * The Servlet creates an instance of the Model in this Java file and
 * using that instance it uses the functions defined in the Model to
 * scrape data. The scrapped data includes population of the state,
 * nickname of the state, capital of the state, song of the state,
 * flower of the state along with its image, and finally an image
 * of the flag of the state.
 *
 * After getting the scrapped data from the Model, it passes the information
 * to output.jsp (which acts as the View) which displays the output in an
 * HTML page to the user along with a Continue button to scrape information
 * for another State.
 */

// Defining the package for this file
package ds.project1task2;

// Imports necessary for handling HttpServlet requests, exceptions and annotation
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * This servlet is defined to get value of a US State from the user using a drop-down menu
 * from index.jsp by connecting the "find-state-info" action. After getting the name of the
 * US State, it uses the funtions defined in Model to scrape data for the US State and
 * relays the output to output.jsp
 */
@WebServlet(name = "findStateInfo", value = "/find-state-info")
public class StateInformationServlet extends HttpServlet {

    /***
     * This servlet will reply to HTTP GET requests via this doGet method
     * @param request Represents the request from HttpServletRequest
     * @param response Represents the response from HttpServletRequest
     * @throws IOException Exception during IO operations
     * @throws ServletException Represents servlet exceptions
     */
    // Source: CMU 95702 Fall 2022 Lab2-InterestingPicture Code
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // Creating an object for the model
        StateInformationModel model = new StateInformationModel();

        // Gets and stores the US State selected by the user
        String user_state = request.getParameter("states");

        String state_nickname; // Stores the nickname of the US State
        String state_capital; // Stores the capital of the US State
        String state_song; // Stores the song of the US State
        String[] state_flower_info; // Stores the flower name and flower image of the US State
        String state_flag_image; // Stores the image of the flag of the US State
        String state_population; // Stores the population of the US State

        // Scrape and store the nickname of the US State using the getStateNickName() function defined in the Model
        state_nickname = model.getStateNickName(user_state);

        // Scrape and store the nickname of the US State using the getStateCapital() function defined in the Model
        state_capital = model.getStateCapital(user_state);

        // Scrape and store the nickname of the US State using the getStateSong() function defined in the Model
        state_song = model.getStateSong(user_state);

        // Scrape and store the nickname of the US State using the getStateFlower() function defined in the Model
        state_flower_info = model.getStateFlower(user_state);

        // Scrape and store the nickname of the US State using the getStateFlag() function defined in the Model
        state_flag_image = model.getStateFlag(user_state);

        // Scrape and store the nickname of the US State using the getStatePopulation() function defined in the Model
        state_population = model.getStatePopulation(user_state);

        // Set attributes for output.jsp file
        // Values of US State name, its population, nickname, capital, song, flower name,
        // flower image (image link), and flag image (image link) are set using the below lines of code
        request.setAttribute("state", user_state);
        request.setAttribute("population", state_population);
        request.setAttribute("nickname", state_nickname);
        request.setAttribute("capital", state_capital);
        request.setAttribute("song", state_song);
        request.setAttribute("flower_name", state_flower_info[0]);
        request.setAttribute("flower_image", state_flower_info[1]);
        request.setAttribute("flag", state_flag_image);

        // Set the next View to be output.jsp displaying the scrapped information
        RequestDispatcher view = request.getRequestDispatcher("output.jsp");

        // Forwards HttpServletRequest request, HttpServletResponse response to the View
        view.forward(request, response);
    }
}
