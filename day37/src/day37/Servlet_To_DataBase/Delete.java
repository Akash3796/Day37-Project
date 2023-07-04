package day37.Servlet_To_DataBase;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Delete extends HttpServlet{
	
			@Override
			protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
				String id = req.getParameter("id");
				
				try{  
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/day_37","root","root");   
					
PreparedStatement ps =con.prepareStatement("Delete from servlet_data where id = ?"); 
						
									ps.setString(1, id);
									
							int result = ps.executeUpdate();
					
								System.out.println(result);
								
					con.close();  
					

					
					}catch(Exception e){ System.out.println(e);}  		

				
			}
}
