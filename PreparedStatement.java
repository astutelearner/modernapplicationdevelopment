import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCExample {

	public static void main(String args[]) {
		try {
			// 1.register the driver
			Class.forName("com.mysql.jdbc.Driver");

			// 2.connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "tiger");

			// 3.Statement
			PreparedStatement stmt = conn.prepareStatement("insert into department values(?,?,?)");
			stmt.setInt(1, 2);
			stmt.setInt(2, 2);
			stmt.setString(3, "ECE");

			// 4.Execute query
			int result = stmt.executeUpdate();

			System.out.println("result---"+result);

			// 5.close the conenction
			conn.close();
		} catch (Exception e) {
         e.printStackTrace();
		}
	}
}
