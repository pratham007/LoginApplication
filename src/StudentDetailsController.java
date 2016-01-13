import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.loginapp.bo.Student;

/**
 * Servlet implementation class DBCon
 */

public class StudentDetailsController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -488895640499465053L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.1.11:1521:ftgdev", "cpg_prod",
					"dev123");
			Statement st = con.createStatement();
			ResultSet rs = st
					.executeQuery("Select CONATCT_ID, FIRST_NAME, LAST_NAME, BIRTH_DATE from stud_dtl");

			List<Student> students = new ArrayList<Student>();
			Student student = null;
			while (rs.next()) {

				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				int contactNo = rs.getInt("CONATCT_ID");
				Date dateOfBirth = rs.getDate("BIRTH_DATE");

				student = new Student();

				student.setContactNo(contactNo);
				student.setDateOfBirth(dateOfBirth);
				student.setFirstName(firstName);
				student.setLastName(lastName);

				students.add(student);

			}

			String studentsJsonStr = new ObjectMapper()
					.writeValueAsString(students);

			pw.write(studentsJsonStr);

			// set content type
			response.setContentType("text/json");

			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
