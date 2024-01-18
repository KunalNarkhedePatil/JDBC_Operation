import java.sql.Connection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.sql.DriverManager;

class Demo {
    public void Display() {
        try {
            int iChoice = 0;
            String sql,PName,PCity;
            int PID;

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Kunal";
            String username = "root";
            String password = "";
            Connection con = DriverManager.getConnection(url, username, password);
            if (con.isClosed()) {
                System.out.println("Connection Failed..");
            } else {
                System.out.println("Connection connected...");
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
                        sql="create table Patient(PID int(15) primary key,PName varchar(255),PCity varchar(255))";
                        stmt.executeUpdate(sql);
                        System.out.println("Table is Created Successfully..");
                        break;
                    case 2:
                        System.out.println("Enter the Patient Id");
                        PID=Integer.parseInt(br.readLine());
                        System.out.println("Enter the Patient Name");
                        PName=br.readLine();
                        System.out.println("Enter the Patient City");
                        PCity=br.readLine();

                        sql="insert into Patient values("+PID+",'"+PName+"','"+PCity+"')";
                        stmt.executeUpdate(sql);
                        System.out.println("Record inserted into the table...");
                        break;
                    case 3:
                        sql="select * from Patient";
                        ResultSet rs=stmt.executeQuery(sql);
                        System.out.println("---------------------------------");
                        while(rs.next())
                        {
                            int id=rs.getInt(1);
                            String Pname=rs.getString(2);
                            String Pcity=rs.getString(3);

                            System.out.println("Patient Id:"+id+"\n"+"Patient Name:"+Pname+"\n"+"Patient City:"+Pcity);
                            System.out.println("---------------------------------");
                        }
                        break;
                    case 4:
                         System.out.println("Enter Patient Id");
                         PID=Integer.parseInt(br.readLine());

                         sql="delete from Patient where PID="+PID;
                         stmt.executeUpdate(sql);

                         System.out.println("Record Deleted Successfully....");
                        
                        break;
                    case 5:
                         System.out.println("Enter Patient Id");
                         PID=Integer.parseInt(br.readLine());
                         System.out.println("Enter Patient Name");
                         PName=br.readLine();

                         sql="update Patient set PName='"+PName+"' where PID="+PID;
                         stmt.executeUpdate(sql);

                         System.out.println("Record Update is successfully.....");
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

class PatientJDBC {
    public static void main(String[] args) {
        Demo dobj = new Demo();
        dobj.Display();
    }
}
