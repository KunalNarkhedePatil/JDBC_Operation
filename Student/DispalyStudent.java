import java.sql.*;
public class DispalyStudent 
{
   public static void main(String rags[])
   {
       try
       {
          Class.forName("com.mysql.cj.jdbc.Driver");
          
          String url="jdbc:mysql://localhost:3306/Student";
          String username="root";
          String password="";
          Connection con=DriverManager.getConnection(url, username, password);

          if(con.isClosed())
          {
              System.out.println("Connection is closed...");
          } 
          else 
          {
              System.out.println("Connection Created Successfully...");
          }

          Statement stmt=con.createStatement();
          ResultSet rs=stmt.executeQuery("select * from Student");

          while(rs.next())
          {
              System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
          }
            con.close();
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
   }
}
