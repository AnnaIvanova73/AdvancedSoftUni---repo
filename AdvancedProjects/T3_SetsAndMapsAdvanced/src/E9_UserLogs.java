import java.util.*;

public class E9_UserLogs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Map<String, Integer>> usersAndIp = new TreeMap<>();

        String input = "";
        while (!"end".equals(input = scan.nextLine())) {
            String[] tokens = input.split("\\s+");
            String ip = tokens[0];
            String user = tokens[2];

            if (!usersAndIp.containsKey(user)) {
                usersAndIp.put(user, new LinkedHashMap<>());
                usersAndIp.get(user).put(ip, 1);
            } else {

                if (!usersAndIp.get(user).containsKey(ip)) {
                    usersAndIp.get(user).put(ip, 1);
                } else {
                    int currentCount = usersAndIp.get(user).get(ip);
                    int newCount = currentCount + 1;
                    usersAndIp.get(user).put(ip, newCount);
                }

            }
        }

        for (Map.Entry<String, Map<String, Integer>> entry : usersAndIp.entrySet()) {
            String key = getWordPerPrint(entry.getKey());
            System.out.println(key + ":");
            Map<String, Integer> innerMap = entry.getValue();

            List<String> print = new LinkedList<>();
            for (Map.Entry<String, Integer> entrySet : innerMap.entrySet()) {
                StringBuilder result = new StringBuilder();

                String ip = getWordPerPrint(entrySet.getKey());
                String number = String.valueOf(entrySet.getValue());

                result.append(ip).append(" => ").append(number);
                print.add(result.toString());
            }

            System.out.print(String.join(", ", print));
            System.out.print(".");
            System.out.println();
        }

    }

    private static String getWordPerPrint(String key) {
        int index = key.indexOf("=");
        String result = key.substring(index + 1);
        return result.trim();
    }
}
