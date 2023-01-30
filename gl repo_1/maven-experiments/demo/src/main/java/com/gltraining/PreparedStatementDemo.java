package com.gltraining;

import java.sql.*;

public class PreparedStatementDemo {
    private Connection connection = null;

    public int startId = 27;
    private PreparedStatement findById = null;
    private PreparedStatement insertStatement = null;


    public static void main(String args[]) {
        PreparedStatementDemo demo = new PreparedStatementDemo();
        demo.start();
    }

    void start() {
        try {
            Class.forName("org.postgresql.Driver");

            // 2 create connection
            String url = "jdbc:postgresql://localhost:5432/empdb";
            String username = "vineet", password = "scooby";
            connection = DriverManager.getConnection(url, username, password);

            insert("manoj", 25, 6000.6, "d2");

            Employee found1 = findById(1);
            Employee found2=findById(2);
            display(found1);
            display(found2);


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

    PreparedStatement createInsertStatement() throws SQLException {
        if (insertStatement != null) {
            return insertStatement;
        }
        String sql = "insert into employees(id,name,age,salary,did) values(?,?,?,?,?)";
        insertStatement = connection.prepareStatement(sql);
        return insertStatement;
    }

    public void insert(String name, int age, double salary, String deptId) throws SQLException {
        int id = ++startId;
        PreparedStatement statement = createInsertStatement();
        statement.setInt(1, id);
        statement.setString(2, name);
        statement.setInt(3, age);
        statement.setDouble(4, salary);
        statement.setString(5, deptId);
        int changed = statement.executeUpdate();
        System.out.println("rows inserted=" + changed);
    }

    public PreparedStatement createFindByIdStatement() throws SQLException {
        if (findById != null) {
            return findById;
        }
        String sql = "select * from employees where id= ?";
        findById = connection.prepareStatement(sql);
        return findById;
    }

    public Employee findById(int id) throws SQLException, EmployeeNotFoundException {
        PreparedStatement statement = createFindByIdStatement();
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
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
