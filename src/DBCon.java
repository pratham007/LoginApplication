import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

public class DBCon extends HttpServlet {

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
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			PreparedStatement st = con.prepareStatement("Select count(*) res from login where USERNM=? and PASSWD=?");
			
			st.setString(1, username);
			st.setString(2, password);

			ResultSet rs = st.executeQuery();
			
			if (rs.next() && rs.getInt(1) == 1) {
				pw.write("success");
			}
			else {
				pw.write("failure");
			}

			// set content type
			response.setContentType("text/plain");

			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
