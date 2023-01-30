package demo;

import java.sql.*;

public class JdbcDemo2 {
    private Connection connection = null;

    public int startId = 12;

    public static void main(String args[]) {
        JdbcDemo2 demo = new JdbcDemo2();
        demo.start();
    }

    void start() {
        try {
            Class.forName("org.postgresql.Driver");

            // 2 create connection
            String url = "jdbc:postgresql://localhost:5432/empdb";
            String username = "vineet", password = "scooby";
            connection = DriverManager.getConnection(url, username, password);

            insert("mirazul", 24, 5000.6, "d1");

            Employee found = findById(1);
            display(found);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (EmployeeNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    public void display(Employee employee) {
        System.out.println(employee.getId() + " " + employee.getName() + " " + employee.getAge() + " " + employee.getSalary());
    }

    public void insert(String name, int age, double salary, String deptId) throws SQLException {
        int id = ++startId;
        Statement statement = connection.createStatement();
     //   String sql = "insert into employees(id,name,age,salary,did) values(" + id + "," + "'"+name+"'" + ","  + age + "," + salary + "," + "'"+deptId + "')";
        String sql=String.format("insert into employees(id,name,age,salary,did) values(%d,'%s',%d,%f,'%s')",id,name,age,salary,deptId);
        int changed = statement.executeUpdate(sql);
        System.out.println("rows inserted=" + changed);
    }

    public Employee findById(int id) throws SQLException, EmployeeNotFoundException {
        Statement statement = connection.createStatement();
        String sql = "select * from employees where id=" + id;
        ResultSet resultSet = statement.executeQuery(sql);
        if (!resultSet.next()) {
            throw new EmployeeNotFoundException("employee not found for id=" + id);
        }
        String name = resultSet.getString("name");
        int age = resultSet.getInt("age");
        double salary = resultSet.getDouble("salary");
        String deptId = resultSet.getString("did");
        Employee employee = new Employee(id, name, age, salary, deptId);
        return employee;

    }


}
