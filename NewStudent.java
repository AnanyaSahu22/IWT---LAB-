
package jdbctest.testpack;
import java.sql.*;
import java.util.*;
public class NewStudent {
public static void main(String []s)
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter your Roll");
String roll=sc.next();
System.out.println("Enter your Name");
String name=sc.next();
System.out.println("Enter your Age");
String age=sc.next();
System.out.println("Enter your Department");
String dept=sc.next();
System.out.println("Enter your CGPA");
String cgpa=sc.next();



try{
String driver = "org.postgresql.Driver";
String url = "jdbc:postgresql://192.168.1.17/cse_db24";
String username = "24beei79";
String password = "24beei79";
String createTableSQL = """
CREATE TABLE IF NOT EXISTS student_jdbc (
    roll_no INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    age INT CHECK (age >= 0),
    department VARCHAR(30),
    cgpa FLOAT(4,2) CHECK (cgpa >= 0.00 AND cgpa <= 10.00)
)
""";
Class.forName(driver);
Connection con = DriverManager.getConnection(url, username, password);
if(con!= null)
System.out.println("Connection established successfully…");
String qry = "INSERT INTO newStudent1(name, sic) VALUES(?,?)";
PreparedStatement ps = con.prepareStatement(qry); 
ps.setString(1, roll);
ps.setString(2, name);
ps.setString(1, age);
ps.setString(2, dept);
ps.setString(1, cgpa);

int i = ps.executeUpdate();
if(i == 1){
System.out.println("Record Inserted successfully");
}
ps.close();
con.close();
} catch (Exception e){
System.out.println(e);
}
}
}

