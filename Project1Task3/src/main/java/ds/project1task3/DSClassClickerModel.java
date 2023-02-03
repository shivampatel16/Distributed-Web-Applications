/**
 * Author: Shivam Patel
 * Andrew ID: shpatel
 * Last Modified: September 23, 2022
 * File: DSClassClickerModel.java
 * Part Of: Project1Task3
 *
 * This Java file acts as the Model for this program.
 * It defines a SortedMap to store the count of the answers to questions posed in the class.
 * The map is sorted based on keys of the map.
 * The Model defines three functions namely incrementAnswerCount(), getResultCount() and resetResults()
 * incrementAnswerCount() - Keeps the count of the answers submitted in the sorted map.
 *                          It increments the count of a particular answer if it is already present
 *                          in the map, or set the count to be 1
 * getResultCount() - It returns the result of the answers and their counts to be printed in results.jsp
 * resetResults() - It resets the map (creates a new map here)
 */

// Defining the package for this file
package ds.project1task3;

// Imports necessary for creating a map to store and process the count of the answers
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class DSClassClickerModel {

    // Stores the count of the answers in a sorted order based on the keys of the map
    // Keys of the map are the answers
    // Value of the map are the counts of the answers
    private SortedMap<String, Integer> answer_map = new TreeMap<>();

    /***
     * Keeps the count of the answers submitted in the sorted map.
     * It increments the count of a particular answer if it is
     * already present in the map, or set the count to be 1.
     * @param answer It is the key (or answer selected by the user) for which the current
     *               count in the  map needs to be increased by one
     */
    public void incrementAnswerCount(String answer) {
        // If the answer (key) is already present in the map
        if (answer_map.containsKey(answer)) {
            // Increment its count (value) by 1
            answer_map.put(answer, answer_map.get(answer) + 1);
        }
        // If the answer (key) is not present in the map
        else {
            // Set its count (value) to be 1
            answer_map.put(answer, 1);
        }
    }

    /***
     * It computes the result of the answers and their counts to be printed in results.jsp
     * @return The string value containing HTML tags that would be printed on results.jsp
     */
    public String getResultCount() {

        // Stores the formatted string output (in HTML form)
        String result = "";

        // If the map is not empty
        if (answer_map.size() != 0) {

            // Start creating the result
            result = result + "<h1>Distributed Systems Class Clicker</h1>" +
                    "The results from the survey are as follows <br><br>";

            // Source: https://www.geeksforgeeks.org/iterate-map-java/
            // For every key value pair that is present in the map
            for (Map.Entry<String,Integer> entry : answer_map.entrySet()) {
                // Add the key and value to the results
                result = result + entry.getKey() + ": " + entry.getValue() + "<br>";
            }
        }
        // If the map of the count of answers is empty
        else {
            result = result + "<h1>Distributed Systems Class Clicker</h1>" +
                    "There are currently no results";
        }

        // Return the formatted results
        return result;
    }

    /***
     * It resets the map of the count of answers selected in the class (creates a new map here)
     */
    public void resetResults() {
        answer_map = new TreeMap<>();
    }
}
