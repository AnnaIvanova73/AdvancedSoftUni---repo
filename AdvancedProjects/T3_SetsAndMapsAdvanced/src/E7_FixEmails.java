import java.util.*;

public class E7_FixEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> peopleAndMeils = new LinkedHashMap<>();
        int counter = 1;
        String key = "";
        String input = "";
        while (!"stop".equals(input = scan.nextLine())) {
            if (counter % 2 != 0) {
                key = input;
                peopleAndMeils.putIfAbsent(key, new ArrayList<>());
            } else {
                int index = input.indexOf('.');
                String current = input.substring(index + 1);
                if (current.equalsIgnoreCase("us")
                        || current.equalsIgnoreCase("uk")
                        || current.equalsIgnoreCase("com")) {
                    peopleAndMeils.remove(key);
                    counter++;
                    continue;
                }

                peopleAndMeils.get(key).add(input);
            }
            counter++;
        }



//        for (Map.Entry<String, List<String>> entrySet : peopleAndMeils.entrySet()) {
//            String currKey = entrySet.getKey();
//            for (String email : entrySet.getValue()) {
//                int index = email.indexOf('.');
//                String current = email.substring(index + 1);
//                if (current.equalsIgnoreCase("us")
//                        || current.equalsIgnoreCase("uk")
//                        || current.equalsIgnoreCase("com")) {
//                    peopleAndMeils.remove(currKey);
//                }
//            }
//        }

        for (Map.Entry<String, List<String>> stringListEntry : peopleAndMeils.entrySet()) {
            System.out.print(stringListEntry.getKey() + " -> ");
            System.out.println(String.join(" ", stringListEntry.getValue()));
        }
    }

}
