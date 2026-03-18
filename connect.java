package mypackage;
import java.sql.*;
public class connect {

	public static void main(String[] args) {
		try
		{
			String driver="org.postgresql.Driver";
			String url="jdbc:postgresql://192.168.1.17/cse_db24";
			String username="24beei79";
			String password="24beei79";
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url,username,password);
			if(con!=null)
				System.out.println("Connection established successfully");
			}catch(Exception e) {
				System.out.println(e);
			}

	}

}
