import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
class Demo
{
    public void Display()
    {
        String sql;
        try
        {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/Kunal";
            String username="kunal";
            String password="Kunal@123";

            Connection con=DriverManager.getConnection(url, username, password);
            if(con.isClosed())
            {
                System.out.println("Connection Failed..");
            }
            else
            {
                System.out.println("Connetion Connected..");
            }
            Statement stmt=con.createStatement();
            System.out.println("Enter the Customer Id:");
            int CId=Integer.parseInt(br.readLine());
            sql="delete from Customer where CId="+CId;
            stmt.executeUpdate(sql);
            System.out.println("Record deleted Successfully...");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
public class DeleteCustomer 
{
    public static void main(String args[])
    {
        Demo dobj=new Demo();
        dobj.Display();
    }
}

