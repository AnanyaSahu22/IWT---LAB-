package jdbctest.testpack;
import java.sql.*;


public class CreateStudentTable {

    public static void main(String[] args) {
        // Database connection details — change according to your setup
        String jdbcURL = "jdbc:mysql://localhost:3306/cse_db24"; // Replace with your DB name
        String dbUser = "24beei79"; // Replace with your DB username
        String dbPassword = "24beei79"; // Replace with your DB password

        // SQL statement to create the student table
        String createTableSQL = """
            CREATE TABLE IF NOT EXISTS student (
                roll_no INT PRIMARY KEY,
                name VARCHAR(50) NOT NULL,
                age INT CHECK (age >= 0),
                department VARCHAR(30),
                cgpa FLOAT(4,2) CHECK (cgpa >= 0.00 AND cgpa <= 10.00)
            )
        """;

        // Load MySQL JDBC driver and create table
        try {
            // Load the JDBC driver (optional for newer JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            try (Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
                 Statement statement = connection.createStatement()) {

                // Execute the SQL statement
                statement.executeUpdate(createTableSQL);
                System.out.println("Table 'student' created successfully (if not exists).");

            } catch (SQLException e) {
                System.err.println("SQL Error: " + e.getMessage());
            }

        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found. Please add it to your classpath.");
        }
    }
}

