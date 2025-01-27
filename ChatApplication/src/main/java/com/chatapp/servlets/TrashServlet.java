package com.chatapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.chatapp.utils.ConProvider;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/trashServlet")
public class TrashServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("header.html").include(request, response);
		request.getRequestDispatcher("link.html").include(request, response);

		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect("index.html");
		} else {
			String email = (String) session.getAttribute("email");
			out.print("<span style='float:right'>Hi, " + email + "</span>");
			out.print("<h1>Trash</h1>");

			String msg = (String) request.getAttribute("msg");
			if (msg != null) {
				out.print("<p>" + msg + "</p>");
			}

			try {
				Connection con = ConProvider.getConnection();
				PreparedStatement ps = con.prepareStatement(
						"select * from frndschat_message where (receiver=? OR sender=?) and trash=? order by id desc");
				ps.setString(1, email);
				ps.setString(2, email);
				ps.setString(3, "yes");

				ResultSet rs = ps.executeQuery();
				out.print("<table border='1' style='width:700px;'>");
				out.print("<tr style='background-color:grey;color:white'><td>Sender</td><td>Subject</td></tr>");
				while (rs.next()) {
					out.print("<tr><td>" + rs.getString("sender") + "</td><td><a href= 'viewServlet2?id="
							+ rs.getString(1) + "'>" + rs.getString("subject") + "</td></tr>");

				}
				out.print("</table>");

				con.close();
			} catch (Exception e) {
				out.print(e);
			}
		}

		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();

	}

}
