package jdbctest.testpack;

import java.sql.*;
import java.util.*;

public class DeleteRecord {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Roll No to delete: ");
        int roll_no = sc.nextInt();

        try {
            String driver = "org.postgresql.Driver";
            String url = "jdbc:postgresql://192.168.1.17/cse_db24";
            String username = "24bcsi36";
            String password = "24bcsi36";

            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, username, password);

            String qry = "DELETE FROM student_jdbc WHERE roll_no = ?";
            PreparedStatement ps = con.prepareStatement(qry);

            ps.setInt(1, roll_no);

            int i = ps.executeUpdate();

            if (i > 0)
                System.out.println("Record Deleted Successfully!");
            else
                System.out.println("Record not found!");

            ps.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
