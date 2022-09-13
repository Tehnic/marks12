import java.util.*;

public class twodm {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Kazakhstan");
        list.add("Latvia");
        list.add("Russia");
        list.add("Ukraine");
        list.add("Belarus");
        int[][] arr = new int [list.size()][1];

        for (int i = 0; i < list.size(); i++) {
            arr[i][0] = list.get(i).length();
        }
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Please enter the number for " + list.get(i));
            arr[i][0] = sc.nextInt();
        }
        sc.close();

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + " " + arr[i][0]);
        }
    }
}
