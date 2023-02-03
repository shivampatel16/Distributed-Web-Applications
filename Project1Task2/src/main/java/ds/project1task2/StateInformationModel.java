/**
 * Author: Shivam Patel
 * Andrew ID: shpatel
 * Last Modified: September 23, 2022
 * File: StateInformationModel.java
 * Part Of: Project1Task2
 *
 * This Java file acts as the Model for this program.
 * It defines six functions to scrape various information of the US State selected by the user.
 * The six functions are:
 * getStateNickName() - scrapes the nickname of the US State
 * getStateCapital() - scrapes the capital of the US State
 * getStateSong() - scrapes the song of the US State
 * getStateFlower() - scrapes the flower name and image (link) of the US State
 * getStateFlag() - scrapes the flag image (link) of the US State
 * getStatePopulation() - scrapes the population of the US State
 */

// Defining the package for this file
package ds.project1task2;

// Imports necessary for scrapping using Jsoup, reading files, and handling exceptions
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class StateInformationModel {

    /***
     * Function to scrape the nickname of the US State as selected by the user
     * @param user_state The name of the US State whose nickname is to be found
     * @return Scrapped nickname of the US State
     */
    public String getStateNickName(String user_state) {

        // Stores the result of the Jsoup scrapped URL for US States nicknames
        // URL for scrapping nickname: https://www.britannica.com/topic/List-of-nicknames-of-U-S-States-2130544
        Document doc_nicknames;
        try {
            // Using Jsoup, connect to the URL, scrape it and store its data
            doc_nicknames = Jsoup.connect("https://www.britannica.com/topic/List-of-nicknames-of-U-S-States-2130544").get();
        }
        // Handles IO exceptions and throws a Runtime exception along with its details
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Using Jsoup selectors, scrape the Document and store the potential elements that contain
        // nickname of the US State
        Elements nicknames = doc_nicknames.select("tbody").select("tr").select("td");

        // Stores the scrapped nickname of the US State
        String state_nickname = "";

        // For every element in nicknames
        for(int i = 0; i < nicknames.size(); i++) {
            // If the desired US State is found in the element
            if (nicknames.get(i).text().equals(user_state)) {
                // Get the nickname of the US state
                state_nickname = nicknames.get(i + 1).text();
            }
        }

        // Return the scrapped nickname of the US State
        return state_nickname;
    }

    /***
     * Function to scrape the capital of the US State as selected by the user
     * @param user_state The name of the US State whose capital is to be found
     * @return Scrapped capital of the US State
     */
    public String getStateCapital(String user_state) {

        // Stores the result of the Jsoup scrapped URL for US States capitals
        // URL for scrapping capitals: https://gisgeography.com/united-states-map-with-capitals/
        Document doc_capitals;
        try {
            // Using Jsoup, connect to the URL, scrape it and store its data
            doc_capitals = Jsoup.connect("https://gisgeography.com/united-states-map-with-capitals/").get();
        }
        // Handles IO exceptions and throws a Runtime exception along with its details
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Using Jsoup selectors, scrape the Document and store the potential elements that contain
        // capitals of the US State
        Elements capitals = doc_capitals.getElementsByClass("kt-inside-inner-col").select("p");

        // Stores the scrapped capital of the US State
        String state_capital = "";

        // For every element in capitals
        for(int i = 0; i < capitals.size(); i++) {
            // Create an array of string split leading to name of capital
            String[] p_split = capitals.get(i).text().split("\\)");
            // If length of string in the split if > 5 (to avoid unnecessary elements further)
            if (p_split.length > 5) {
                // For every string split
                for (int j = 0; j < p_split.length; j++) {
                    // If the desired US State is found in the element
                    if (p_split[j].split("\\(")[0].contains(user_state)) {
                        // Get the capital of the US state
                        state_capital = p_split[j].split("\\(")[1];
                    }
                }
            }
        }
        // Return the scrapped capital of the US State
        return state_capital;
    }

    /***
     * Function to scrape the song of the US State as selected by the user
     * @param user_state The name of the US State whose song is to be found
     * @return Scrapped song of the US State
     */
    public String getStateSong(String user_state) {

        // Stores the result of the Jsoup scrapped URL for US States songs
        // URL for scrapping songs: https://www.50states.com/songs/
        Document doc_songs;
        try {
            // Using Jsoup, connect to the URL, scrape it and store its data
            doc_songs = Jsoup.connect("https://www.50states.com/songs/").get();
        }
        // Handles IO exceptions and throws a Runtime exception along with its details
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Using Jsoup selectors, scrape the Document and store the potential elements that contain
        // song of the US State
        Elements songs = doc_songs.select("dl");

        // Stores the scrapped song of the US State
        String state_song = "";

        // For every element in songs
        for(int i = 0; i < songs.size(); i++) {
            // If the desired US State is found in the element
            if (songs.get(i).select("dt").text().equals(user_state)) {
                // Create a new set of elements to scrape multiple songs for the US which has more than one song
                Elements songs_dds = songs.get(i).select("dd");

                // For every song element
                for(int j = 0; j < songs_dds.size(); j++) {
                    // Scrape the first song and come out of the loop, since we need only one song
                    state_song = songs_dds.get(j).text();
                    break;
                }
            }
        }
        // Return the scrapped song of the US State
        return state_song;
    }

    /***
     * Function to scrape the flower name and flower image link of the US State as selected by the user
     * @param user_state The name of the US State whose flower name and flower image link is to be found
     * @return String array with two strings flower name and flower image link of the US State
     */
    public String[] getStateFlower(String user_state) {

        // Stores the result of the Jsoup scrapped URL for US States flowers
        // URL for scrapping flowers: https://statesymbolsusa.org/categories/flower
        Document doc_flowers;
        try {
            // Using Jsoup, connect to the URL, scrape it and store its data
            doc_flowers = Jsoup.connect("https://statesymbolsusa.org/categories/flower").get();
        }
        // Handles IO exceptions and throws a Runtime exception along with its details
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Using Jsoup selectors, scrape the Document and store the potential elements that contain
        // flowers of the US State
        Elements flowers = doc_flowers.select(".view-symbols > .view-content ul li");

        // Stores the flower name and flower image of the US State
        String[] state_flower_info = new String[2];

        // Stores the flower name the US State
        String state_flower_name = null;

        // Stores the flower image link of the US State
        String state_flower_image = null;

        // For every element in flowers
        for(int i = 0; i < flowers.size(); i++) {
            // Find and select a subset of elements with ccs query div
            Elements flowers_divs = flowers.get(i).select("div");
            // If the desired US State is found in the element
            if (flowers_divs.get(2).text().equals(user_state)) {
                // Get the first flower image link of the US state
                state_flower_image = flowers_divs.get(1).select("img").attr("src");
                // Get the first flower name of the US state
                state_flower_name = flowers_divs.get(3).text();

                // Break since we need details of only one flower
                break;
            }
        }

        // Add flower name and flower image link in state_flower_info
        state_flower_info[0] = state_flower_name;
        state_flower_info[1] = state_flower_image;

        // Return the scrapped flower information of the desired US state
        return state_flower_info;
    }

    /***
     * Function to scrape the flag image link of the US State as selected by the user
     * @param user_state The name of the US State whose flag image link is to be found
     * @return Scrapped flag image link of the US State
     */
    public String getStateFlag(String user_state) {

        // Stores the result of the Jsoup scrapped URL for US States flags
        // URL for scrapping flags: https://www.states101.com/flags
        Document doc_flags;
        try {
            // Using Jsoup, connect to the URL, scrape it and store its data
            doc_flags = Jsoup.connect("https://www.states101.com/flags").get();
        }
        // Handles IO exceptions and throws a Runtime exception along with its details
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Using Jsoup selectors, scrape the Document and store the potential elements that contain
        // flags of the US State
        Elements flags = doc_flags.select("div.content > div.row > .col-md-3.col-sm-4.col-xs-6");

        // Stores the scrapped flag image link of the US State
        String state_flag_image = "";

        // For every element in flags
        for(int i = 0; i < flags.size(); i++) {
            // If the desired US State is found in the element
            if (flags.get(i).select("a").text().equals(user_state + " ")) {
                // Get and form the complete image link of the flag of the US state
                state_flag_image = "https://www.states101.com" + flags.get(i).select("p > a > img").attr("src");
            }
        }

        // Return the scrapped flag image link of the US State
        return state_flag_image;
    }

    /***
     * Function to scrape the population of the US State as selected by the user
     * @param user_state The name of the US State whose population is to be found
     * @return Scrapped population of the US State
     */
    public String getStatePopulation(String user_state) {

        // Stores the scrapped population of the US State
        String state_population = "";

        // Source: https://stackoverflow.com/questions/43698645/read-local-file-in-intellij-idea-javaee-web-application-deployed-with-tomcat
        // Create a URI object to read the CSV file containing FIPS values of the states
        URI uri;
        try {
            // Read the CSV file
            uri = Objects.requireNonNull(StateInformationServlet.class.getClassLoader().getResource("fips.csv")).toURI();
        }
        // Handles URI syntax exceptions and throws a Runtime exception along with its details
        catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        // Stores the fips of all states (to be cleaned later in the code)
        String fips_values;
        try {
            // Get the FIPS values of all states in one string
            fips_values = String.valueOf(Files.readAllLines(Paths.get(uri)));
        }
        // Handles IO exceptions and throws a Runtime exception along with its details
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Format fips values to be cleaned further
        fips_values = fips_values.substring(1,fips_values.length() - 1);

        // Create a split based on commas
        String[] fips_split = fips_values.split(",");

        // Stores the fips of the desirved US state
        String user_state_fips = "";

        // For every string in fips split
        for (int i = 0; i < fips_split.length; i++) {
            // If the desired US state is found
            if (fips_split[i].contains(user_state)) {
                // Store the US state fips and come out of the loop
                user_state_fips = fips_split[i + 1];
                break;
            }
        }

        // Creates and stores the link to be scrapped for finding the population of the desired US state
        // The website requires and API call. API was got from https://api.census.gov/data/key_signup.html
        // API Key = a5c5a24598a6575a96967635c42f210918dd111f
        String population_link = "https://api.census.gov/data/2020/dec/pl?get=NAME,P1_001N&for=state: " + user_state_fips + "&key=a5c5a24598a6575a96967635c42f210918dd111f";

        // Stores the result of the Jsoup scrapped URL for US States population
        // URL for scrapping population: population_link (as above)
        Document doc_population;
        try {
            // Using Jsoup, connect to the URL, scrape it and store its data
            doc_population = Jsoup.connect(population_link).ignoreContentType(true).get();
        }
        // Handles IO exceptions and throws a Runtime exception along with its details
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Using Jsoup selectors, scrape the Document and store the potential elements that contain
        // population of the US State
        Elements population = doc_population.select("body");

        // Scrape the population of the desired US state
        state_population = population.text().split(",")[4].split("\"")[1];

        // Return the scrapped population of the US State
        return state_population;
    }
}