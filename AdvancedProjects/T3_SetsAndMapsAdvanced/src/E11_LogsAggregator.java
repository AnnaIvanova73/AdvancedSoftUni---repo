import java.util.*;
import java.util.stream.Collectors;

public class E11_LogsAggregator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countLogs = Integer.parseInt(scan.nextLine());

        Map<String, Map<Integer,TreeSet<String>>> usersData = new TreeMap<>();
        while(countLogs -- > 0){
            String[] tokens = scan.nextLine().split("\\s+");

            String name = tokens[1];
            int duration = Integer.parseInt(tokens[2]);
            TreeSet<String> ips = new TreeSet<>(){{add(tokens[0]);}};

            if(!usersData.containsKey(name)){
                usersData.putIfAbsent(name, new LinkedHashMap<>());
                usersData.get(name).put(duration, ips); // не дава с интерфейс само Set
            }else{
                    Map<Integer, TreeSet<String>> temp = usersData.get(name);
                    int currentValue = duration;
                    TreeSet<String> tempValue = new TreeSet<>();
                    for (Map.Entry<Integer, TreeSet<String>> entry : temp.entrySet()) {
                        int asdf = entry.getKey();
                        currentValue+=entry.getKey();
                        tempValue.addAll(entry.getValue());
                    }
                    tempValue.addAll(ips);
                    usersData.get(name).clear();
                    usersData.get(name).put(currentValue,tempValue);
            }
        }
        usersData.forEach((key, value) -> {
            System.out.print(key + ": ");
            value.forEach((key1, value1) -> {
                System.out.print(key1 + " ");
                System.out.println(value1);
            });
        });
    }
}
