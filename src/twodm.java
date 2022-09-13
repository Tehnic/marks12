import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class twodm {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Kazakhstan");
        list.add("Latvia");
        list.add("Russia");
        list.add("Ukraine");
        list.add("Belarus");
        ArrayList<ArrayList<String>> list2 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String json = "";
            try {
                URL url = new URL("https://jsonmock.hackerrank.com/api/countries/search?name="+list.get(i));
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.connect();
                int responsecode = conn.getResponseCode();
                if (responsecode != 200) {
                    throw new RuntimeException("HttpResponseCode: " + responsecode);
                } else {
                    Scanner sc = new Scanner(url.openStream());
                    while (sc.hasNext()) {
                        json += sc.nextLine();
                    }
                    sc.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            String[] jsonSplit = json.split("population");
            ArrayList<String> countries = new ArrayList<>();
            for (int j = 1; j < jsonSplit.length; j++) {
                String[] jsonSplit2 = jsonSplit[j].split(",");
                countries.add(jsonSplit2[0].substring(2));
            }

            for (String str : countries) {
                System.out.println(str);
            }
        }
    }
}
