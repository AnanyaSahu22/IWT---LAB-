package jdbctest.testpack;
import java.sql.*;
import java.util.*;
public class UpdateRecord {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Roll No to update: ");
		int roll_no = sc.nextInt();

		System.out.print("Enter new CGPA: ");
		float cgpa = sc.nextFloat();
		try {
			String driver = "org.postgresql.Driver";
			String url = "jdbc:postgresql://192.168.1.17/cse_db24";
			String username = "24beei79";
			String password = "24beei79";
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, username, password);
			String qry = "UPDATE student_jdbc SET cgpa = ? WHERE roll_no = ?";
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setFloat(1, cgpa);
			ps.setInt(2, roll_no);

			int i = ps.executeUpdate();
			if (i > 0)
				System.out.println("Record Updated Successfully!");
			else
				System.out.println("Record not found!");
			ps.close();
			con.close();
			} catch (Exception e) {
				System.out.println(e);
				}
	}
}


