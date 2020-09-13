import java.util.*;
import java.util.stream.Collectors;

public class L7_AcademyGraduation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scan.nextLine());


        Map<String,List<Double>> graduationsList = new TreeMap<>();
        while(numberOfStudents-- > 0){

            String name = scan.nextLine();
            List<Double> grades = Arrays.stream(scan.nextLine().split("\\s+"))
                    .map(Double :: parseDouble).collect(Collectors.toList());

                if(!graduationsList.containsKey(name)){
                    graduationsList.put(name, new ArrayList<>());
                    graduationsList.get(name).addAll(grades);
                }else{
                    graduationsList.get(name).addAll(grades);
                }
        }

        for (Map.Entry<String, List<Double>> entry : graduationsList.entrySet()) {
            System.out.print(entry.getKey() + " is graduated with ");
            List<Double> gradesPerStudent = entry.getValue();
            double sum = 0;
            for (Double currGrade : gradesPerStudent) {
                sum += currGrade;
            }
            int gradesCount = gradesPerStudent.size();
            double avg = sum / (gradesCount * 1.0);
            System.out.println(avg);
        }
    }
}
