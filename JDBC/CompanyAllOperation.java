import java.sql.Connection;
import java.sql.Driver;
import java.io.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;

class Demo {
    public void Display() {
        try {
            int iChoice = 0, CId;
            String sql, CName, CCity;

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Kunal";
            String username = "kunal";
            String password = "Kunal@123";

            Connection con = DriverManager.getConnection(url, username, password);
            if (con.isClosed()) {
                System.out.println("Connection Failed");
            } else {
                System.out.println("Connetion Connected Successfully..");
            }
            Statement stmt = con.createStatement();

            while (true) {
                System.out.println("1.Create");
                System.out.println("2.Insert");
                System.out.println("3.Display");
                System.out.println("4.Delete");
                System.out.println("5.Update");
                System.out.println("6.Exit");
                System.out.println("Enter Your Choice");

                iChoice = Integer.parseInt(br.readLine());

                switch (iChoice) {
                    case 1:
                        sql = "create table Company(CID int(20) primary key,CName varchar(255),CCity varchar(255))";
                        stmt.executeUpdate(sql);
                        System.out.println("Table is created successfully");
                        break;
                    case 2:
                        System.out.println("Enter the Company Id:");
                        CId = Integer.parseInt(br.readLine());
                        System.out.println("Enter the Company Name:");
                        CName = br.readLine();
                        System.out.println("Enter the Company City:");
                        CCity = br.readLine();
                        sql = "insert into Company values(" + CId + ",'" + CName + "','" + CCity + "')";
                        stmt.executeUpdate(sql);
                        System.out.println("Insert the record successfully...");
                        break;
                    case 3:
                        sql = "select * from Company";
                        ResultSet rs = stmt.executeQuery(sql);
                        System.out.println("--------------------------------------");
                        while (rs.next()) {
                            CId = rs.getInt(1);
                            CName = rs.getString(2);
                            CCity = rs.getString(3);

                            System.out.println("Company Id:" + CId + "\n" + "Company Name:" + CName + "\n"
                                    + "Company City:" + CCity);
                            System.out.println("--------------------------------------");
                        }
                        break;
                    case 4:
                        System.out.println("Enter the Company Id");
                        CId = Integer.parseInt(br.readLine());
                        sql = "delete from Company where CId=" + CId;
                        stmt.executeUpdate(sql);
                        System.out.println("Record deleted successfuly...");
                        break;
                    case 5:
                        System.out.println("Enter the Comapany Id");
                        CId = Integer.parseInt(br.readLine());
                        System.out.println("Enter the new City name");
                        CCity = br.readLine();
                        sql = "update Company set CCity='" + CCity + "' where CId=" + CId;
                        stmt.executeUpdate(sql);
                        System.out.println("Record Update is successfully.....");
                        break;
                    case 6:
                        System.exit(0);
                        break;
                    default:
                        break;

                }
            }

        } catch (Exception E) {
            E.printStackTrace();
        }

    }
}

public class CompanyAllOperation {
    public static void main(String args[]) {
        CustomerAllOperation dobj = new CustomerAllOperation();
        dobj.Display();

    }
}
