import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class countrylist {
    public static void main(String[] args) {
        Locale[] locales = Locale.getAvailableLocales();
        ArrayList<String> countryList = new ArrayList<String>();
        for (Locale locale : locales) {
            String country = locale.getDisplayCountry(Locale.ENGLISH);
            if (country.length() > 0 && !countryList.contains(country)) {
                countryList.add(country);
            }
        }

        Collections.sort(countryList);
        for (String country : countryList) {
            System.out.println(country);
        }

        // Calculate the number of letters in the country names
        int total = 0;
        for (String country : countryList) {
            total += country.length();
        }
        System.out.println("Total number of letters in country names: " + total);

        // Calculate the average number of letters in the country names
        double average = (double) total / countryList.size();
        System.out.println("Average number of letters in country names: " + average);

        // Calculate the number of countries with names that have more than 7 letters
        int count = 0;
        for (String country : countryList) {
            if (country.length() > 7) {
                count++;
            }
        }
        System.out.println("Number of countries with names that have more than 7 letters: " + count);

        // Establish the longest country name
        String longest = "";
        for (String country : countryList) {
            if (country.length() > longest.length()) {
                longest = country;
            }
        }
        System.out.println("Longest country name: " + longest);

        // Establish the shortest country name
        String shortest = "abcdefghijklmnopqrstuvwxyz";
        for (String country : countryList) {
            if (country.length() < shortest.length()) {
                shortest = country;
            }
        }
        System.out.println("Shortest country name: " + shortest);
        // Create a JSON file with the country names
        System.out.println("Creating JSON file...");
        String json = "{ \"countries\": [";
        for (String country : countryList) {
            json += "\"" + country + "\",";
        }
        json = json.substring(0, json.length() - 1);
        json += "]}";
        System.out.println(json);
        System.out.println("JSON file created.");
        //

    }
}
