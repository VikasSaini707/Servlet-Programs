package com.ustglobal.webapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Assignment extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int empid = Integer.parseInt(req.getParameter("empid"));

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3307/ust_ty_db";
			conn = DriverManager.getConnection(url,"root","root");


			String sql = "select * from emp where id=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, empid);

			rs = pstmt.executeQuery();

			PrintWriter out = resp.getWriter();
			if(rs.next()) {
				int emp_id = rs.getInt("id");
				int sal = rs.getInt("sal");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				
				out.println("<html>");
				out.println("<body>");
				
				out.println("<table border='2px'>");
				out.println("<tr>");
					out.println("<th>");
						out.println("ID");
					out.println("</th>");
					out.println("<th>");
						out.println("Name");
					out.println("</th>");
					out.println("<th>");
						out.println("Salary");
					out.println("</th>");
					out.println("<th>");
						out.println("Gender");
					out.println("</th>");
					
					out.println("</tr>");
				
					out.println("<tr>");
					out.println("<td>");
						out.println(emp_id);
					out.println("</td>");
					out.println("<td>");
						out.println(name);
					out.println("</td>");						
					out.println("<td>");
						out.println(sal);
					out.println("</td>");	
					out.println("<td>");
						out.println(gender);
					out.println("</td>");	
					out.println("</tr>");
				
				out.println("</table>");
				
				out.println("</body>");
				out.println("</html>");
			}
			else
			{
				
				out.println("No Data Found");
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				if(conn!=null)
					conn.close();
				if(pstmt!=null)
					pstmt.close();
				if(rs!=null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
