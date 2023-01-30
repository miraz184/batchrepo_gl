package demo;

import org.postgresql.Driver;

import java.sql.*;

public class JdbcDemo1 {

    public static void main(String args[]) {
        JdbcDemo1 demo = new JdbcDemo1();
        demo.start();
    }


    void start(){
        //1 register driver

        // Driver driver=new Driver();
        //DriverManager.registerDriver(driver);
        Connection connection =null;
        try {

            Class.forName("org.postgresql.Driver");

            // 2 create connection
            String url = "jdbc:postgresql://localhost:5432/empdb";
            String username = "vineet", password = "scooby";
           connection = DriverManager.getConnection(url, username, password);

            //3 create statement

            Statement statement = connection.createStatement();

            // 4 execute query
            String sql = "select * from employees";
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                int id = resultset.getInt("id");
                String name = resultset.getString("name");
                int age = resultset.getInt("age");
                double salary = resultset.getDouble("salary");
                System.out.println(id + "-" + name + "-" + age + "-" + salary);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        finally {
            if(connection!=null) {
                try {
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }



    }


}
