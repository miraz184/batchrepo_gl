package demos.inheritance;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmployeeTest {

    public static void main(String args[]){
        EmployeeTest demo=new EmployeeTest();
        List<Employee> list=new ArrayList<>();
        list.add(new Employee(1, "manoj"));
        list.add(new Employee(2,"abhishedk"));
        Set<Employee>managed=new HashSet<>();
        managed.add(new Employee(2,"abhishedk"));
        Manager manager=new Manager(3,"akshata",managed);
        list.add(manager);
        for (Employee iteratedEmployee:list){
            boolean isManager=iteratedEmployee instanceof Manager;
            if(isManager){
               Manager iteratedManager=(Manager)iteratedEmployee;
               demo.displayManager(iteratedManager);
            }else{
                demo.displayEmployee(iteratedEmployee);
            }
        }
    }

    void displayEmployee(Employee employee){
        System.out.println(employee.getId()+"-"+ employee.getName());
    }

    void displayManager(Manager manager){
        System.out.println("**manager details");
        displayEmployee(manager);
        System.out.println("managing employees");
        for (Employee employee:manager.getManaged()){
            displayEmployee(employee);
        }
    }

}
