
import java.sql.*;
public class UpdateStudent 
{
   public static void main(String args[])  
   {
       try
       {
           Class.forName("com.mysql.cj.jdbc.Driver");
           String url="jdbc:mysql://localhost:3306/Student";
           String username="kunal";
           String password="Kunal@123";
           String sql="update Student set name='Bharat' where RollNo=13";

           Connection con=DriverManager.getConnection(url, username, password);

           if(con.isClosed())
           {
               System.out.println("Connection is Failed...");
           }
           else
           {
               System.out.println("Connetion Established SuccessFully..");

           }
           Statement stmt=con.createStatement();
           
           stmt.executeUpdate(sql);
           System.out.println("Database updated successfully...");
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
   }
}
