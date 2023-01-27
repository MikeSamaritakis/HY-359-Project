package Servlets.Functions;

import database.DB_Connection;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.*;

@WebServlet("/StudentBorrowBook")
public class StudentBorrowBook extends HttpServlet {
    private static final long serialVersionUID = 1L; //https://www.codejava.net/coding/java-servlet-and-jsp-hello-world-tutorial-with-eclipse-maven-and-apache-tomcat

    public StudentBorrowBook(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//  Edit info for Students

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><body>");

        try {
            DB_Connection.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String query = "select username from students";
        Statement stmt = null;
        try {
            stmt = DB_Connection.getConnection().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ResultSet rs;

        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try
        {


             rs = stmt.executeQuery("select * from books");
            out.println("<table border=1 width=50% height=50%>");

            while (rs.next())
            {
                String n = rs.getString("isbn");
                String nm = rs.getString("title");
                int s = rs.getInt("pages");
                out.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + s + "</td></tr>");
            }
            out.println("</table>");
            out.println("</html></body>");

        }
        catch (Exception e)
        {
            out.println("error");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//  Edit info for Librarians
    }
}
