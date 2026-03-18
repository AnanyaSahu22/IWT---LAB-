package mypackage;
import java.sql.*;
import java.util.*;
public class InsertRecord {
			public static void main(String[] args)
			{
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter your name");
				String name=sc.next();
				System.out.println("Enter your SIC no.");
				String sic=sc.next();
				try {
					String driver="org.postgresql.Driver";
					String url="jdbc:postgresql://192.168.1.17/cse_db24";
					String username="24bcsi36";
					String password="24bcsi36";
					Class.forName(driver);
					Connection con=DriverManager.getConnection(url,username,password);
					if(con!=null)
						System.out.println("Connection established successfully...");
				}
				
				String qry="INSER INTO Student1(name,sic)VALUES(?,?)";
				PreparedStatement ps= con.prepareStatement(qry);
				ps.setString(1,name);
				ps.setString(2,sic);
				int i=ps.executeUpdate();
				if(i==1) {
					System.out.println("Record Inserted Successfully");
				}
				ps.close();
				con.close();
				}catch(Exception e){
				System.out.println(e);
				}
}
}

			

