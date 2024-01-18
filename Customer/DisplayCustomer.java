import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;

class Demo {
    public void Display() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Kunal";
            String username = "root";
            String password = "";

            Connection con = DriverManager.getConnection(url, username, password);

            if(con==null)
            {
                System.out.println("Connection Failed");
            }
            else
            {
                System.out.println("Connection Successfully");
            }
            Statement stmt = con.createStatement();

            String sql = "select * from Customer";

            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("----------------------------------------");
            while (rs.next()) {
                int CId = rs.getInt(1);
                String CName = rs.getString(2);
                String CCity = rs.getString(3);
                String PName = rs.getString(4);

                System.out.println("Customer Id:" + CId + "\n" + "Customer Name:" + CName + "\n" + "Customer City:"
                        + CCity + "\n" + "Product Name:" + PName);
                        System.out.println("----------------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class DisplayCustomer {
    public static void main(String[] args) {
        Demo dobj = new Demo();
        dobj.Display();
    }
}