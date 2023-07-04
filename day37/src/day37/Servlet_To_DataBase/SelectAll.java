package day37.Servlet_To_DataBase;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectAll extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/day_37", "root", "root");
				
			ArrayList user = new ArrayList();
			
			PreparedStatement ps = con.prepareStatement("SELECT * from servlet_data");

			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				String name = rs.getString("Ename");
				String mob = rs.getString("mobile");
				String mail = rs.getString("email");
				String pass = rs.getString("password");
				
				SetAttr sa = new SetAttr();
				sa.setName(name);
				sa.setMob(mob);
				sa.setMail(mail);
				sa.setPass(pass);
				
				user.add(sa);
			}
				
			req.setAttribute("userList", user);
			
			RequestDispatcher rd = req.getRequestDispatcher("BootstrapTable.jsp");
			rd.include
			(req, res);
			
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}


	}
}
