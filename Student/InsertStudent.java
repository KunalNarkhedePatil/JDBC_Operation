import java.sql.*;

class InsertStudent {
    public static void main(String argd[])
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/Student";
            String username="kunal";
            String password="Kunal@123";
            Connection con=DriverManager.getConnection(url, username, password);

            if(con.isClosed())
            {
                System.out.println("Connection is Failed");
            }
            else
            {
                System.out.println("Connection Created Successfully..");

            }

            Statement stmt=con.createStatement();
            System.out.println("Inserting records into the table...");

            String sql="Insert into Student values(14,'Bharat','Pimpri',95)";
            stmt.executeUpdate(sql);

            
            String sql1="Insert into Student values(15,'Mayur','Hadapsar',85)";
            stmt.executeUpdate(sql1);

            
            String sql2="Insert into Student values(16,'Sumit','Pune',90)";
            stmt.executeUpdate(sql);

            System.out.println("Inserted the records into the table");

            
            con.close();
        }

    catch(Exception e)
    {
        e.printStackTrace();
    }
}}