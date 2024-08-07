import com.google.gson.*;
import java.net.*;
import java.util.*;

public class Arraylist {
    public static void main(String[] args) {
        Locale[] locales = Locale.getAvailableLocales();
        Locale obj = new Locale("en", "US");
        ArrayList<String> countryNames = new ArrayList<>();
        for (Locale locale : locales) {
            String country = locale.getDisplayCountry(obj);
            if (country.length() > 0 && !countryNames.contains(country)) {
                countryNames.add(country);
            }
        }
        System.out.println(countryNames);

        ArrayList<String> countryList = new ArrayList<String>();
        ArrayList<String> population = new ArrayList<String>();
        ArrayList<String> codesList = new ArrayList<String>();
        ArrayList<ArrayList<String>> combinedList = new ArrayList<>(); //countryList + population
        countryList.add("Kazakhstan");
        countryList.add("Latvia");
        countryList.add("Russia");
        countryList.add("Ukraine");
        countryList.add("Belarus");
        for (String str : countryList) {
            System.out.println(str);
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your country below: (enter 'stop' to exit):");
        while (!sc.hasNext("stop")) {
            String country = sc.nextLine();
            if (countryNames.contains(country)) {
                if (countryList.contains(country)) {
                    System.out.println("The country is already in the list");
                } else {
                    countryList.add(country);
                    System.out.println("The country is not in the list, added");
                }
            } else {
                System.out.println("Please enter a valid country name!");
            }
        }

        for (String str : countryList) {
            System.out.println(str);
        }

        for (String str : countryList) {
            for (Locale locale : locales) {
                String country = locale.getDisplayCountry(obj);
                if (country.equals(str)) {
                    codesList.add(locale.getCountry());
                }
            }
        }
        LinkedHashSet<String> lhs = new LinkedHashSet<>(codesList);
        codesList.clear();
        codesList.addAll(lhs);

        for (int i = 0; i < codesList.size(); i++) {
            try {
                URL url = new URL("https://jsonmock.hackerrank.com/api/countries/search?alpha2Code=" + codesList.get(i));
                Scanner scanner = new Scanner(url.openStream());
                String result = "";
                while (scanner.hasNext()) {
                    result += scanner.nextLine();
                }
                Gson gson = new Gson();
                JsonObject jsonObject = gson.fromJson(result, JsonObject.class);
                JsonArray jsonArray = jsonObject.getAsJsonArray("data");
                JsonObject data = jsonArray.get(0).getAsJsonObject();
                String pop = data.get("population").getAsString();
                population.add(pop);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < countryList.size(); i++) {
            ArrayList<String> list2 = new ArrayList<String>();
            list2.add(countryList.get(i));
            list2.add(population.get(i));
            combinedList.add(list2);
        }

        System.out.println("Choose how to sort the list: 1 - by country name, 2 - by population");
        Scanner sc3 = new Scanner(System.in);
        while (true) {
            String choice = sc3.nextLine();
            switch (choice) {
                case "1":
                    Collections.sort(combinedList, new Comparator<ArrayList<String>>() {
                        public int compare(ArrayList<String> o1, ArrayList<String> o2) {
                            return o1.get(0).compareTo(o2.get(0));
                        }
                    });
                    break;
                case "2":
                    Collections.sort(combinedList, new Comparator<ArrayList<String>>() {
                        public int compare(ArrayList<String> o1, ArrayList<String> o2) {
                            return Integer.valueOf(o1.get(1)).compareTo(Integer.valueOf(o2.get(1)));
                        }
                    });
                    break;
                default:
                    System.out.println("Please enter a valid choice!");
                    continue;
            }
            System.out.println(combinedList);
        }
    }
}