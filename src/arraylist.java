import java.util.*;

public class arraylist {
    public static void main(String[] args) {

        Locale[] locales = Locale.getAvailableLocales();
        Locale objEnglish = new Locale("en", "US");
        Locale objRussian = new Locale("ru", "RU");
        ArrayList<String> countryNames = new ArrayList<>();
        for (Locale locale : locales) {
            String countryEng = locale.getDisplayCountry(objEnglish);
            String countryRus = locale.getDisplayCountry(objRussian);
            if (countryEng.length() > 0 && !countryNames.contains(countryEng)) {
                countryNames.add(countryEng);
            }
            if (countryRus.length() > 0 && !countryNames.contains(countryRus)) {
                countryNames.add(countryRus);
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

            if (countryNames.contains(country) && !list.contains(country)) {
                for (int i = 0; i < list.size(); i++) {
                    for (Locale locale : locales) {
                        String countryEng = locale.getDisplayCountry(objEnglish);
                        String countryRus = locale.getDisplayCountry(objRussian);
                        if (list.get(i).equals(countryRus)) {
                            list.set(i, countryEng);
                        }
                    }
                }
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
        System.out.println("ArrayList: " + list);

        /*for (int i = 0; i < list.size(); i++) {
            for (Locale locale : locales) {
                String countryEng = locale.getDisplayCountry(objEnglish);
                String countryRus = locale.getDisplayCountry(objRussian);
                if (list.get(i).equals(countryRus)) {
                    list.set(i, countryEng);
                }
            }
        }*/

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    list.remove(j);
                    j--;
                }
            }
        }

        Collections.sort(list);
        System.out.println("Sorted ArrayList: " + list);
        System.out.println("Size of ArrayList: " + list.size());
        for (String str : list) {
            System.out.println(str);
        }
    }
}