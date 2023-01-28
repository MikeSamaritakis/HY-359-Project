package Servlets;

import database.DB_Connection;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet()
public class AdminViewUser extends HttpServlet {
    private static final long serialVersionUID = 1L; //https://www.codejava.net/coding/java-servlet-and-jsp-hello-world-tutorial-with-eclipse-maven-and-apache-tomcat

    public AdminViewUser(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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


            rs = stmt.executeQuery("select * from students");
            out.println("<table border=1 width=50% height=50%>");
 out.println("Students \n");
            while (rs.next())
            {

                String n = rs.getString("username");

                out.println("<tr><td>" + n  + "</td></tr>");
            }
            out.println("</table>");
            out.println("</html></body>");

        }
        catch (Exception e)
        {
            out.println("error");
        }



        String query2 = "select username from librarians";
        Statement stmt2 = null;
        try {
            stmt2 = DB_Connection.getConnection().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ResultSet rs2;

        try {
            rs2 = stmt2.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try
        {


            rs2 = stmt2.executeQuery("select * from librarians");
            out.println("<table border=1 width=50% height=50%>");
            out.println("Librarians \n");
            while (rs2.next())
            {

                String n = rs2.getString("username");

                out.println("<tr><td>" + n  + "</td></tr>");
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

    }
}
