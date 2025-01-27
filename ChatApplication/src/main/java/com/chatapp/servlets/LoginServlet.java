package com.chatapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.chatapp.utils.LoginDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    request.getRequestDispatcher("header.html").include(request, response);

	    String email = request.getParameter("email");
	    String password = request.getParameter("password");

	    if (LoginDao.validate(email, password)) {
	        out.print("<div class='message success'>You are successfully logged in!</div>");
	        request.getSession().setAttribute("login", "true");
	        request.getSession().setAttribute("email", email);
	        response.sendRedirect("inboxServlet");
	    } else {
	        out.print("<div class='message error'>Sorry, username or password error.</div>");
	        request.getRequestDispatcher("login.html").include(request, response);
	    }

	    request.getRequestDispatcher("footer.html").include(request, response);
	    out.close();
	}
}
