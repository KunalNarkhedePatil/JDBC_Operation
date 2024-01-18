import java.io.*;
import java.sql.*;

class Demo1 {
    public void Display() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String sql, CName, CCity, PName;
            int CID;
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Kunal";
            String username = "root";
            String password = "";

            Connection con = DriverManager.getConnection(url, username, password);
            if (con.isClosed()) {
                System.out.println("Connection failed...");
            } else {
                System.out.println("Connection connected Successfully");
            }
            Statement stmt = con.createStatement();
            System.out.println("Enter the Customer Id ");
            CID = Integer.parseInt(br.readLine());
            System.out.println("Enter the Customer Name ");
            CName = br.readLine();
            System.out.println("Enter the Customer City");
            CCity = br.readLine();
            System.out.println("Enter the Prodect Name");
            PName = br.readLine();

            sql = "insert into Customer values(" + CID + ",'" + CName + "','" + CCity + "','" + PName + "')";
            stmt.executeUpdate(sql);
            System.out.println("Record Inserted into tables...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class InsertCustomer{
    public static void main(String args[])
    {
        Demo1 dobj=new Demo1();
        dobj.Display();
    }
}
