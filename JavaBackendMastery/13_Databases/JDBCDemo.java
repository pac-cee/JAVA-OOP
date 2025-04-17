// Demonstrates connecting to a database using JDBC
import java.sql.*;
public class JDBCDemo {
    public static void main(String[] args) throws Exception {
        // Replace with your DB credentials
        String url = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String password = "password";
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM students");
        while (rs.next()) {
            System.out.println(rs.getString("name") + ", " + rs.getInt("age"));
        }
        rs.close(); stmt.close(); conn.close();
    }
}
