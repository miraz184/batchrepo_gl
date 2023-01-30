package demos.inheritance;

import java.util.Set;

public class Manager extends Employee{

    private Set<Employee> managed;

    public Manager(int id, String name, Set<Employee>manages){
        super(id,name);
        this.managed=manages;
    }

    public Set<Employee>getManaged(){
        return managed;
    }
}
