import java.sql.*;
class Demo
{
   public void Display()
   {
       try
       {
           String sql;
           Class.forName("com.mysql.cj.jdbc.Driver");
           String url="jdbc:mysql://localhost:3306/Kunal";
           String username="kunal";
           String password="Kunal@123";
           Connection con=DriverManager.getConnection(url, username, password);

           if(con.isClosed())
           {
               System.out.println("Connection failed...");
           }
           else
           {
               System.out.println("Connection created successfully...");
           }

           Statement stmt=con.createStatement();
           sql="create table Customer(CId int(20) primary key,CName varchar(255),CCity varchar(255),PName varchar(255))";
           stmt.executeUpdate(sql);
           System.out.println("Table created successfully...");

       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
   }
}
class CreateCustomer
{
   public static void main(String args[])
   {
       Demo dobj=new Demo();
       dobj.Display();
   }
}
