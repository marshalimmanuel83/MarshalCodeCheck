package com.luv2code.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
/**
 * Servlet implementation class TestDbConnection
 */
@WebServlet("/TestDbConnection")
public class TestDbConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestDbConnection() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		testDbConnection(request, response);
	}

	private void testDbConnection(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String jdbcURL = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
		String username = "springstudent";
		String password = "springstudent";

		String jdbcDriver = "com.mysql.cj.jdbc.Driver";

		try {

			PrintWriter out = response.getWriter();
			out.println("Connecting to database: " + jdbcURL);

			Class.forName(jdbcDriver);
			Connection conn = DriverManager.getConnection(jdbcURL, username, password);

			out.println("Database Connection Successful!!");

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
