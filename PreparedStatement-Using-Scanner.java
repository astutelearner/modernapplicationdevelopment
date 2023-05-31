import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JDBCExample {

	public static void main(String args[]) {
		try {
			// 1.register the driver
			Class.forName("com.mysql.jdbc.Driver");

			// 2.connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "tiger");

			// 3.Statement
			PreparedStatement stmt = conn.prepareStatement("insert into department values(?,?,?)");
			Scanner s=new Scanner(System.in);
			System.out.println("please enter the sno");
			int sno=s.nextInt();
			stmt.setInt(1, sno);
			System.out.println("please enter the departmentid");
			int departmentId=s.nextInt();
			stmt.setInt(2, departmentId);
			System.out.println("please enter the department name");
			String name=s.next();
			stmt.setString(3, name);

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
