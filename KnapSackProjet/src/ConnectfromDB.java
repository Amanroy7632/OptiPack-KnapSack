/* Steps to connect or fetch data from database
Step 1: Register the JDBC Driver
Step 2: Create connection using drivermanager class
Step 3: Using connection create a statement object
Step 5: Execute query using statement object and store data in ResultSet 
Step 6: close the connection*/
import java.sql.*;
public class ConnectfromDB {
    Connection con;
    Statement st;
    ConnectfromDB(){
       
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/knapsack","root","aman7632@");
           st=con.createStatement();
           ResultSet rs=st.executeQuery("select id,name from customer");
           while (rs.next()) {
            System.out.println(rs.getString("id")+" -- "+rs.getString("name"));
           }
           

        }catch(Exception e){
            System.out.println(e);
        }
    }
    public  void getData(){
        try{
           ResultSet rs=st.executeQuery("select id,name from customer");
           while (rs.next()) {
            System.out.println(rs.getString("id")+" -- "+rs.getString("name"));
           }
        }catch(Exception e){   
        }  
    }
    public static void main(String[] args) {
        new ConnectfromDB().getData();
    }
}
