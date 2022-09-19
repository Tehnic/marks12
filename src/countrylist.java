import java.net.URL;
import java.util.*;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

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


        ArrayList<String> countryList2 = new ArrayList<String>();
        ArrayList<String> population = new ArrayList<String>();
        countryList2.add("Kazakhstan");

        //get population of countries in countryList2 from API not using Country class
        String url = "https://jsonmock.hackerrank.com/api/countries/search?name=";
        for (String country : countryList2) {
            String countryUrl = url + country;
            try {
                URL restCountries = new URL(countryUrl);
                Scanner scanner = new Scanner(restCountries.openStream());
                String result = "";
                while (scanner.hasNext()) {
                    result += scanner.nextLine();
                }
                scanner.close();
                Gson gson = new Gson();
                JsonObject jsonObject = gson.fromJson(result, JsonObject.class);
                JsonArray jsonArray = jsonObject.getAsJsonArray("data");
                JsonObject data = jsonArray.get(0).getAsJsonObject();
                String pop = data.get("population").getAsString();
                population.add(pop);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println(population);
        }

    }
}
