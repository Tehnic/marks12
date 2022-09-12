import java.util.*;

public class arraylist {
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
        ArrayList<String> list = new ArrayList<>(5);
        list.add("Kazakhstan");
        list.add("Latvia");
        list.add("Russia");
        list.add("Ukraine");
        list.add("Belarus");
        System.out.println("ArrayList: " + list);

        Collections.sort(list);
        System.out.println("Sorted ArrayList: " + list);
        System.out.println("Size of ArrayList: " + list.size());
        for (String str : list) {
            System.out.println(str);
        }


        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your country below: (enter 'stop' to exit):");
        while (!sc.hasNext("stop")) {
            String country = sc.nextLine();
            if (countryNames.contains(country)) {
                if (list.contains(country)) {
                    System.out.println("The country is already in the list");
                } else {
                    list.add(country);
                    System.out.println("The country is not in the list, added");
                }
            } else {
                System.out.println("Please enter a valid country name!");
            }

        }
        sc.close();
        Collections.sort(list);
        System.out.println("Sorted ArrayList: " + list);
        System.out.println("Size of ArrayList: " + list.size());
        for (String str : list) {
            System.out.println(str);
        }
    }
}