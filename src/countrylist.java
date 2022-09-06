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
    }
}
