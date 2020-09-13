import java.util.*;

public class L5_AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scan.nextLine());

        Map<String, List<Double>> students = new TreeMap<>();
        while (numberOfStudents-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");

            String student = tokens[0];
            double grade = Double.parseDouble(tokens[1]);

            students.putIfAbsent(student, new ArrayList<>());

            if (students.containsKey(student)) {
                students.get(student).add(grade);
            }
        }

        for (Map.Entry<String, List<Double>> entry : students.entrySet()) {
            String key = entry.getKey();
            System.out.print(key + " -> ");
            entry.getValue().forEach(g -> System.out.printf("%.2f ",g));
            List<Double> values = entry.getValue();
            double sum = 0;
            for (Double value : values) {
               sum = sum + value;
            }
            System.out.printf("(avg: %.2f)\n",sum/values.size());;
        }

    }


}
