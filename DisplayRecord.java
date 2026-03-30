package jdbctest.testpack;
import java.sql.*;
import java.util.*;
public class DisplayRecord {
public static void main(String []s)
{
String name,sic;
try{
String driver = "org.postgresql.Driver";
String url = "jdbc:postgresql://192.168.1.17/cse_db24";
String username = "24beei79";
String password = "24beei79";
Class.forName(driver);
Connection con = DriverManager.getConnection(url, username, password);
if(con!= null)
System.out.println("Connection established successfully");
String qry = "SELECT * FROM newStudent1";
PreparedStatement ps = con.prepareStatement(qry);
ResultSet rs = ps.executeQuery();
while(rs.next()){
System.out.println(rs.getString("name"));
System.out.println(rs.getString("sic"));
}
ps.close();
con.close();
} catch (Exception e){
System.out.println(e);
}
}
}