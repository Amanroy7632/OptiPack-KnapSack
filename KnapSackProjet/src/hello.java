import java.sql.Statement;
// import java.sql.Connection;
// import java.sql.DriverManager;
// import javax.swing.JOptionPane;
// import java.sql.SQLException;
// public class hello {
//     public static void main(String[] args) {
//         try{
//             String url="jdbc:mysql://localhost:3306/";
//             String databasename="my_db";
//             String userName="root";
//             String password="aman7632@";
//             Connection conn=DriverManager.getConnection(url, userName, password);
//             String sql="CREATE DATABASE "+databasename;
//             Statement statement=conn.createStatement();
//             statement.excuteUpdate(sql);
//             statement.close();
//             System.out.println("Database creaed t");
//             // JOptionPane.showMessageDialog(null, databasename, "database created successfully");
//         }
//         catch(Exception a){
//             System.out.println(a);
//         }
//     }
// }
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class hello {
    public static void main(String[] args) {
        // Database URL, username, and password
        String url = "jdbc:mysql://localhost:3306/"; // Replace 'mydatabase' with your database name
        String username = "root"; // Replace with your MySQL username
        String password = "aman7632@"; // Replace with your MySQL password
        String databaseName="Knapsack_aman";
        // Establish a connection
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            
            // Check if the connection is successful
            if (connection != null) {
                System.out.println("Connected to the database!");
                Statement statement = connection.createStatement();
            String createDatabaseSQL = "drop database" + databaseName;
            statement.executeUpdate(createDatabaseSQL);
            System.out.println("Database '" + databaseName + "' created successfully.");
            connection.close();
                // You can perform database operations here

                // Don't forget to close the connection when you're done
                connection.close();
            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
    }
}
