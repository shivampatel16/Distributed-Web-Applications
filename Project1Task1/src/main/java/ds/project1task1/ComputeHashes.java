/**
 * Author: Shivam Patel
 * Andrew ID: shpatel
 * Last Modified: September 23, 2022
 * File: ComputeHashes.java
 * Part Of: Project1Task1
 *
 * This Java file acts as a Servlet (Controller) for this program.
 * It computes hash values of string inputted by the user. It allows the user to
 * choose from two hash functions, namely MD5 and SHA256 (MD5 being the default).
 * It gets the string and preferred hash function from the user, and
 * uses functions defined (computeMD5() or computeSHA256()) in
 * ComputeHashesModel.java to find the hash value of the string input
 * in hexadecimal and base64 notations.
 *
 * After getting the hash values from the Model, it passes the information
 * to results.jsp (which acts as the View) which displays the output in an
 * HTML page to the user.
 */

// Defining the package for this file
package ds.project1task1;

// Imports necessary for handling HttpServlet requests, exceptions and annotation
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * This servlet is defined to get values of user string and the required hash function
 * from index.jsp by connecting the "compute-hashes" action. After getting the necessary
 * details, it computes hashes and relays the output to result.jsp
 */
@WebServlet(name = "computeHashes", value = "/compute-hashes")
public class ComputeHashes extends HttpServlet {

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
        ComputeHashesModel model = new ComputeHashesModel();

        // Gets and stores the string inputted by the user
        String user_input = request.getParameter("userString");

        // Gets and stores the preferred hash function of the user
        String hash_function = request.getParameter("hash_function");

        // String array to store the hexadecimal and base64 notion of hash of user_input
        String[] hashes = new String[0];

        // Stores the hexadecimal notion of hash of user_input
        String hex_hash;

        // Stores the base64 notion of hash of user_input
        String b64_hash;

        // If user selected MD5 hash function
        if (hash_function.equalsIgnoreCase("md5")) {
            // Compute the MD5 hash and store hexadecimal and base64 notions
            hashes =  model.computeMD5(user_input);
        }
        // If user selected SHA 256 hash function
        else if (hash_function.equalsIgnoreCase("sha-256")) {
            // Compute the SHA 256 hash and store hexadecimal and base64 notions
            hashes =  model.computeSHA256(user_input);
        }

        // Extract hexadecimal and base64 notions from the hashes String array
        hex_hash = hashes[0];
        b64_hash = hashes[1];

        // Set attributes for results.jsp file
        // Values of user's string, the preferred hash function, hexadecimal and base64 notions are set
        request.setAttribute("user_input", user_input);
        request.setAttribute("hash_function", hash_function);
        request.setAttribute("hex_hash", hex_hash);
        request.setAttribute("b64_hash", b64_hash);

        // Set the next View to be result.jsp displaying the hash values
        RequestDispatcher view = request.getRequestDispatcher("result.jsp");

        // Forwards HttpServletRequest request, HttpServletResponse response to the View
        view.forward(request, response);
    }
}