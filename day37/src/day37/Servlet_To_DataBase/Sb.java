package day37.Servlet_To_DataBase;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.PreparableStatement;

public class Sb extends HttpServlet {

				@Override
				protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
						
							String name = req.getParameter("name");
							String mail = req.getParameter("email");
							String pass = req.getParameter("password");
							String mob = req.getParameter("mobile");
							
							try{  
								Class.forName("com.mysql.jdbc.Driver");  
								Connection con=DriverManager.getConnection(  
								"jdbc:mysql://localhost:3306/day_37","root","root");   
								
								PreparedStatement ps =con.prepareStatement("INSERT INTO servlet_data( Ename , mobile, email, password) values ( ?,?,?,?)"); 
									
												ps.setString(1, name);
												ps.setString(2, mail);
												ps.setString(3, pass);
												ps.setString(4, mob);
												
										int result = ps.executeUpdate();
								
											System.out.println(result);
											
								con.close();  
								
		
								
								}catch(Exception e){ System.out.println(e);}  
							
							
							SetAttr sa = new SetAttr(name, mail, pass, mob);
							req.setAttribute("edata", sa);
							
							RequestDispatcher rd = req.getRequestDispatcher("BrowsData.jsp");
							rd.forward(req, res);		

				}
}
