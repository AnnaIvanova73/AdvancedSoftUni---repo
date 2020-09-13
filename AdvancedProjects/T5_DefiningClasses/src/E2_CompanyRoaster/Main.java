package E2_CompanyRoaster;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int counter = Integer.parseInt(scan.nextLine());


        Set<String> namesDep = new HashSet<>();
        Set<Department> saveDep = new HashSet<>();
        while (counter-- > 0) {

            String[] tokens = scan.nextLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];
            String email;
            int age;

            if(!namesDep.contains(department)){
                Department newDep = new Department(department,new ArrayList<>());
                saveDep.add(newDep);
                namesDep.add(department);
            }
            Employee employee;
            switch (tokens.length) {
                case 4:
                    employee = new Employee(name, salary, position, department);
                    break;
                case 5:
                    try {
                        age = Integer.parseInt(tokens[4]);
                        employee = new Employee(name, salary, position, department, age);
                    } catch (NumberFormatException e) {
                        email = tokens[4];
                        employee = new Employee(name, salary, position, department, email);
                    }

                    break;
                default:
                    age = Integer.parseInt(tokens[5]);
                    email = tokens[4];
                    employee = new Employee(name, salary, position, department, email, age);
                    break;
            }

            for (Department current : saveDep) {
                if(current.getDepartment().equals(department)){
                    current.getEmployees().add(employee);
                }
            }

        }


        double highestAvgSalary = 0;
        Department highestPaid = null;
        for (Department department : saveDep) {
            double avgSalary = department.getEmployees().stream()
                    .mapToDouble(Employee::getSalary)
                    .average().orElse(0);

            if (avgSalary > highestAvgSalary) {
                highestAvgSalary = avgSalary;
                highestPaid = department;
            }
        }

        assert highestPaid != null;
        System.out.printf("Highest Average Salary: %s%n",highestPaid.getDepartment());
        highestPaid.getEmployees().stream().sorted((e1,e2) ->Double.compare(e2.getSalary(),e1.getSalary()))
                .forEach(employee -> {
                    System.out.printf("%s %.2f %s %d%n",employee.getName(), employee.getSalary(),
                            employee.getEmail(), employee.getAge() );
                });

    }
}
