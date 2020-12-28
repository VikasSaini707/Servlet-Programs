package com.emp.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login.html")
public class LoginPageServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();

		String id = "";
		Cookie[] cookies = req.getCookies();
		if(cookies!=null)
		{
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("alwaysRemember"))
				{
					id = cookie.getValue();
				}
			}
		}

		out.println("<html>");
		out.println("<fieldset align='center'>");
		out.println("<legend>Welcome to Login Page</legend>");
		out.println("<form action='./login' method='post'>");
		out.println("<table align='center'>");

		out.println("<tr>");
		out.println("<td>ID:</td>");
		out.println("<td><input type='number' name='id' value='"+id+"'></td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Password:</td>");
		out.println("<td><input type='password' name='password'></td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td><input type='checkbox' name='rememberme' value='checked'></td>");
		out.println("<td>Remember me</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td><input type='reset' value='Reset'></td>");
		out.println("<td><input type='submit' value='Login'></td>");
		out.println("</tr>");

		out.println("<a href='register.html'>Click here to Register</a>");
		out.println("</table>");
		out.println("</form>");
		out.println("</fieldset>");
		out.println("</html>");


	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
}
