package day37.Servlet_To_DataBase;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Select extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/day_37", "root", "root");

			PreparedStatement ps = con.prepareStatement("SELECT * from servlet_data where id = ?");

			ps.setString(1, id);

			ResultSet rs = ps.executeQuery();
			rs.next();
			
			req.setAttribute("id", rs.getInt("id"));
			req.setAttribute("name", rs.getString("Ename"));
			req.setAttribute("mobile", rs.getString("mobile"));
			req.setAttribute("email", rs.getString("email"));
			req.setAttribute("password", rs.getString("password"));
			
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		// SetAttr sa = new SetAttr(name, mail, pass, mob);
		// req.setAttribute("edata", sa);

		RequestDispatcher rd = req.getRequestDispatcher("BrowsData.jsp");
		rd.forward(req, res);

	}
}
