/**
 * Author: Shivam Patel
 * Andrew ID: shpatel
 * Last Modified: September 23, 2022
 * File: ComputeHashesModel.java
 * Part Of: Project1Task1
 *
 * This Java file acts as the Model for this program.
 * It has two functions called computeMD5() and computeSHA256().
 * computeMD5() computes the MD5 hash value of the string passed
 * into the function, converts the hash into hexadecimal and
 * base64 notations and return these two notations.
 * computeSHA256() computes the SHA256 hash value of the string passed
 * into the function, converts the hash into hexadecimal and
 * base64 notations and return these two notations.
 */

// Defining the package for this file
package ds.project1task1;

// Imports necessary for computing hash values
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ComputeHashesModel {

    /***
     * computes the MD5 hash value of the string passed
     * into the function, converts the hash into hexadecimal and
     * base64 notations and return these two notations.
     * @param user_input String input from the user whose hash values are to be computed
     * @return A String array of two values. First is the hexadecimal notion
     *         of the MD5 hash of user_input and the second is the base64 notion
     *         of the MD5 hash of user_input
     */
    public String[] computeMD5(String user_input) {

        // String array to store the hexadecimal and base64 notion of MD5 hash of user_input
        String[] hashes = new String[2];

        // Source: CMU 95702 Fall 2022 Lab1-InstallationAndRaft Code
        try {
            // Access MessageDigest class for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Compute the digest
            md.update(user_input.getBytes());

            // Store digest as a byte array for further use
            byte[] digest = md.digest();

            // Compute hexadecimal notion of MD5 hash value of user_input
            String hex_hash = javax.xml.bind.DatatypeConverter.printHexBinary(digest);

            // Compute base64 notion of MD5 hash value of user_input
            String b64_hash = javax.xml.bind.DatatypeConverter.printBase64Binary(digest);

            // Add the hexadecimal and base64 notions to hashes String array
            hashes[0] = hex_hash;
            hashes[1] = b64_hash;
        }
        // Handles No MD5 Algorithm exceptions
        catch(NoSuchAlgorithmException e) {
            // Print error message in console
            System.out.println("No MD5 available" + e);
        }
        // Return the hexadecimal and base64 notions of MD5 hash of user_input
        return hashes;
    }

    /***
     * computes the SHA256 hash value of the string passed
     * into the function, converts the hash into hexadecimal and
     * base64 notations and return these two notations.
     * @param user_input String input from the user whose hash values are to be computed
     * @return A String array of two values. First is the hexadecimal notion
     *         of the SHA256 hash of user_input and the second is the base64 notion
     *         of the SHA256 hash of user_input
     */
    public String[] computeSHA256(String user_input) {

        // String array to store the hexadecimal and base64 notion of SHA256 hash of user_input
        String[] hashes = new String[2];

        // Source: CMU 95702 Fall 2022 Lab1-InstallationAndRaft Code
        try {
            // Access MessageDigest class for SHA256
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Compute the digest
            md.update(user_input.getBytes());

            // Store digest as a byte array for further use
            byte[] digest = md.digest();

            // Compute hexadecimal notion of SHA256 hash value of user_input
            String hex_hash = javax.xml.bind.DatatypeConverter.printHexBinary(digest);

            // Compute base64 notion of SHA256 hash value of user_input
            String b64_hash = javax.xml.bind.DatatypeConverter.printBase64Binary(digest);

            // Add the hexadecimal and base64 notions to hashes String array
            hashes[0] = hex_hash;
            hashes[1] = b64_hash;
        }
        // Handles No SHA-256 Algorithm exceptions
        catch(NoSuchAlgorithmException e) {
            // Print error message in console
            System.out.println("No SHA-256 available" + e);
        }
        // Return the hexadecimal and base64 notions of SHA256 hash of user_input
        return hashes;
    }
}
