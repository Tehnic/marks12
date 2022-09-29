import java.util.*;

public class Burkani {
    public static void main(String[] args) {
        ArrayList<String> weekdays = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Ludzu ievadiet katru dienas burkānu piegadātu kilogramu: (ievadiet 'stop' lai izietu):");
        while (!sc.hasNext("stop")) {
            String burkani = sc.nextLine();
            weekdays.add(burkani);
        }
        sc.close();

        ArrayList<String> weekdays2 = new ArrayList<>();
        weekdays2.addAll(weekdays);
        System.out.println("1. Veikals kopīgi strādaja: " + (weekdays.size()/7)+" nedēļas un " + (weekdays.size()%7) + " dienas");
        double sum = 0;
        for (String str : weekdays) {
            sum += Double.parseDouble(str);
        }
        System.out.println("2. Kopā piegādāts "+String.format("%.3f",sum)+" burkānu kilogrami");

        double max = 0;
        for (String str : weekdays) {
            if (Double.parseDouble(str) > max) {
                max = Double.parseDouble(str);
            }
        }
        double min = max;
        for (String str : weekdays) {
            if (Double.parseDouble(str) < min) {
                min = Double.parseDouble(str);
            }
        }
        System.out.println("3. Visvairāk piegādāts "+String.format("%.3f",max)+" un vismazāk piegādāts "+String.format("%.3f",min)+" burkānu kilogrami");
        double average = sum / weekdays.size();
        System.out.println("4. Vidēji piegādāts "+String.format("%.3f",average)+" burkānu kilogrami");

        int count = 0;
        for (String str : weekdays) {
            if (Double.parseDouble(str) > 5) {
                count++;
            }
        }
        System.out.println("5. "+count+" dienas piegādāts vairāk par 5 kilogramiem");

        int count2 = 0;
        for (String str : weekdays) {
            if (Double.parseDouble(str) == 0) {
                count2++;
            }
        }
        System.out.println("6. "+count2+" dienas piegādāts 0 kilogrami");

        Collections.sort(weekdays, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return Double.compare(Double.parseDouble(o1), Double.parseDouble(o2));
            }
        });
        System.out.println("7. Dienas sakārtotas pēc piegādātā burkānu kilogramu daudzuma:");
        System.out.println(weekdays);

        int count3 = 0;
        for (String str : weekdays) {
            if (Double.parseDouble(str) > average) {
                count3++;
            }
        }
        System.out.println("8. "+count3+" dienas piegādāts vairāk nekā vidēji");

        Collections.sort(weekdays, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return Double.compare(Double.parseDouble(o2), Double.parseDouble(o1));
            }
        });
        System.out.println("9. Daudzums sakārtotas pēc piegādātā burkānu kilogramu dilstošā secībā:");
        System.out.println(weekdays);

        List<List<String>> subLists = new ArrayList<>();
        for (int i = 0; i < weekdays2.size(); i += 7) {
            subLists.add(weekdays2.subList(i, Math.min(i + 7, weekdays2.size())));
        }

        System.out.println("10. Burkānu piegāde pēc nedēļām:");
        double sum2 = 0;
        for (List<String> list : subLists) {
            for (String str : list) {
                sum2 += Double.parseDouble(str);
            }
            System.out.println(String.format("%.3f",sum2)+" kilogrami");
            sum2 = 0;
        }

        for (List<String> list : subLists) {
            Collections.sort(list, new Comparator<String>() {
                public int compare(String o1, String o2) {
                    return Double.compare(Double.parseDouble(o2), Double.parseDouble(o1));
                }
            });
        }
        System.out.println("11. Burkānu piegāde pēc nedēļām dilstošā secībā:");
        for (List<String> list : subLists) {
            System.out.println(list);
        }

        double max2 = 0;
        int week = 0;
        for (List<String> list : subLists) {
            for (String str : list) {
                sum2 += Double.parseDouble(str);
            }
            if (sum2 > max2) {
                max2 = sum2;
                week = subLists.indexOf(list);
            }
            sum2 = 0;
        }
        System.out.println("12. Visvairāk burkānu piegādāts "+(week+1)+". nedēļā");

        System.out.println("13. Burkānu vidēja piegāde pēc nedēļām:");
        double sum3 = 0;
        for (List<String> list : subLists) {
            for (String str : list) {
                sum3 += Double.parseDouble(str);
            }
            System.out.println((subLists.indexOf(list)+1)+". nedēļā piegādāts vidēji "+String.format("%.3f",sum3/list.size())+" burkānu kilogrami");
            sum3 = 0;
        }

        ArrayList<String> moreThan10 = new ArrayList<>();
        ArrayList<String> lessThan10 = new ArrayList<>();
        for (String str : weekdays) {
            if (Double.parseDouble(str) > 10) {
                moreThan10.add(str);
            } else {
                lessThan10.add(str);
            }
        }
        Collections.sort(moreThan10, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return Double.compare(Double.parseDouble(o1), Double.parseDouble(o2));
            }
        });
        Collections.sort(lessThan10, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return Double.compare(Double.parseDouble(o1), Double.parseDouble(o2));
            }
        });

        System.out.println("14. Burkānu piegāde pēc daudzuma augošā secībā (vispirms vairāk par 10kg, pēc tam mazāk par 10kg):");
        moreThan10.addAll(lessThan10);
        System.out.println(moreThan10);
    }
}