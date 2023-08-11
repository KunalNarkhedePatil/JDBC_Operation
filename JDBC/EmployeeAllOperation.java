import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.*;

//import javax.lang.model.util.ElementScanner14;

class Demo {
    public void Display() {
        try {
            int iChoice = 0;
            String sql,eName,eCity;
            int eId,iNo=0;

            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Employee";
            String username = "kunal";
            String password = "Kunal@123";
            Connection con = DriverManager.getConnection(url, username, password);

            if (con.isClosed()) {
                System.out.println("Connection is failed..");
            } else {
                System.out.println("Connection is Created..");
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
                        sql="create table Emp(eId int(20) primary key,eName varchar(255) not null,eCity varchar(255))";
                        stmt.executeUpdate(sql);
                        System.out.println("Table Created SuccessFully...");
                        break;
                    case 2:
                        System.out.println("Enter the Employee Id:");
                        eId=Integer.parseInt(br.readLine());
                        System.out.println("Enter the Employee name:");
                        eName=br.readLine();
                        System.out.println("Enter the City:");
                        eCity=br.readLine();

                        sql="insert into Emp values("+eId+",'"+eName+"','"+eCity+"')";
                        stmt.executeUpdate(sql);
                        System.out.println("Inserted the record into the table..");

                        break;
                    case 3:
                        sql="select * from Emp";
                        ResultSet rs=stmt.executeQuery(sql);
                        System.out.println("----------------------------------");
                        while(rs.next())
                        {
                            
                            int id=rs.getInt(1);
                            String name=rs.getString(2);
                            String city=rs.getString(3);

                            System.out.println("Employee Id :"+id+"\n"+"Employee Name :"+name+"\n"+"Employee City :"+city);
                            System.out.println("----------------------------------");
                        }

                        break;
                    case 4:
                         System.out.println("Enter the Employee Id:");
                         eId=Integer.parseInt(br.readLine());
                         sql="delete from Emp where eId="+eId;
                         iNo=stmt.executeUpdate(sql);
                         
                        System.out.println("Record Deleted Successfully...");
                        break;
                    case 5:
                         System.out.println("Enter the Employee Id:");
                         eId=Integer.parseInt(br.readLine());
                         System.out.println("Enter the Employee name:");
                         eName=br.readLine();
                        sql="update Emp set eName='"+eName+"' where eId="+eId;
                        iNo=stmt.executeUpdate(sql);
                        
                        System.out.println("Record Update successfully..");
                        
                        break;
                    case 6:
                         con.close();
                         System.exit(0);
                        break;
                    default:

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class EmployeeAllOperation {
    public static void main(String args[]) {
        Demo dobj = new Demo();

        dobj.Display();
    }
}