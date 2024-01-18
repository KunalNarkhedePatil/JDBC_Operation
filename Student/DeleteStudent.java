import java.sql.*;

public class DeleteStudent 
{
    public static void main(String args[])
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/Student";
            String username="root";
            String password="";
            String sql="delete from Student where RollNo=15";
            
            Connection con=DriverManager.getConnection(url, username, password);

            if(con.isClosed())
            {
                System.out.println("Connetion is Failed..");
            }
            else
            {
                System.out.println("Connection Establish Successfully...");
            }

            Statement stmt=con.createStatement();

            stmt.executeUpdate(sql);
            System.out.println("Record deleted successfully...");
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
