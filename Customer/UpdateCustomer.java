import java.io.*;
import  java.sql.*;
class Demo1
{
   public void Display()
   {
       try
       {
           String sql;

          BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
          Class.forName("com.mysql.cj.jdbc.Driver");
          String url="jdbc:mysql://localhost:3306/Kunal";
          String username="kunal";
          String password="Kunal@123";

          Connection con=DriverManager.getConnection(url, username, password);
          if(con.isClosed())
          {
              System.out.println("Connection Failed");
          }
          else
          {
              System.out.println("Connetion connected Successfully...");
          }
          Statement stmt=con.createStatement();
          System.out.println("Enter the New Name");
          String CName=br.readLine();
          System.out.println("Enter the Customer Id:");
          int CId=Integer.parseInt(br.readLine());

          sql="update Customer set CName='"+CName+"' where CId="+CId;
          stmt.executeUpdate(sql);
          System.out.println("Record Updated Successfully....");
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
   }
}
class UpdateCustomer 
{
   public static void main(String args[])   
   {
       Demo1 dobj=new Demo1();
       dobj.Display();
   }
}
