package E2_CompanyRoaster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String department;
    private List<Employee> employees;

    public Department(String department, List<Employee> employees){
        this.department = department;
        this.employees = new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public String getDepartment (){
       return  this.department;
    }

}
