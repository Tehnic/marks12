import java.util.*;

public class Burkani {
    public static void main(String[] args) {
        ArrayList<String> weekdays = new ArrayList<>();
        weekdays.add("Pirmdiena");
        weekdays.add("Otrdiena");
        weekdays.add("Trešdiena");
        weekdays.add("Ceturtdiena");
        weekdays.add("Piektdiena");
        weekdays.add("Sestdiena");
        weekdays.add("Svētdiena");

        Scanner sc = new Scanner(System.in);
        for (String str : weekdays) {
            System.out.print("Cik burkānu kilogramus piegādāti "+weekdays.get(weekdays.indexOf(str))+": ");
            double number = sc.nextDouble();
            weekdays.set(weekdays.indexOf(str), str + " " + number);
        }
        sc.close();
        for (String str : weekdays) {
            System.out.println(str);
        }

        System.out.println("1. Veikals kopīgi stradaja: " + weekdays.size()+" dienas");
        double sum = 0;
        for (String str : weekdays) {
            String[] parts = str.split(" ");
            String part2 = parts[1];
            sum += Double.parseDouble(part2);
        }
        System.out.println("2. Kopā piegādāti "+String.format("%.3f",sum)+" burkānu kilogrami");

        double max = 0;
        double min = 0;
        for (String str : weekdays) {
            String[] parts = str.split(" ");
            String part2 = parts[1];
            double number = Double.parseDouble(part2);
            if (number > max) {
                max = number;
            }
            if (number < min) {
                min = number;
            }
        }
        System.out.println("3. Visvairāk piegādāts "+String.format("%.3f",max)+" un vismazāk piegādāts "+String.format("%.3f",min)+" burkānu kilogrami");
        double average = sum / weekdays.size();
        System.out.println("4. Vidēji piegādāti "+String.format("%.3f",average)+" burkānu kilogrami");

        int count = 0;
        for (String str : weekdays) {
            String[] parts = str.split(" ");
            String part2 = parts[1];
            double number = Double.parseDouble(part2);
            count = (number > 5) ? count + 1 : count;
        }
        System.out.println("5. "+count+" dienas piegādāts vairāk par 5 kilogramiem");

        int count2 = 0;
        for (String str : weekdays) {
            String[] parts = str.split(" ");
            String part2 = parts[1];
            double number = Double.parseDouble(part2);
            count2 = (number == 0) ? count2 + 1 : count2;
        }
        System.out.println("6. "+count2+" dienas piegādāts 0 kilogrami");

        Collections.sort(weekdays, new Comparator<String>() {
            public int compare(String o1, String o2) {
                String[] parts1 = o1.split(" ");
                String part1 = parts1[1];
                String[] parts2 = o2.split(" ");
                String part2 = parts2[1];
                return Double.compare(Double.parseDouble(part1), Double.parseDouble(part2));
            }
        });
        System.out.println("7. Dienas sakārtotas pēc piegādātā burkānu kilogramu daudzuma:");
        for (String str : weekdays) {
            System.out.println(str);
        }

        int count3 = 0;
        for (String str : weekdays) {
            String[] parts = str.split(" ");
            String part2 = parts[1];
            double number = Double.parseDouble(part2);
            count3 = (number > average) ? count3 + 1 : count3;
        }
        System.out.println("8. "+count3+" dienas piegādāti vairāk nekā vidēji");
    }
}