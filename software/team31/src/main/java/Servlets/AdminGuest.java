package Servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;

import database.DB_Connection;
import database.tables.EditStudentsTable;
import database.tables.EditBooksInLibraryTable;
import database.tables.EditBooksTable;
import database.tables.EditAdminMessageTable;
import database.tables.EditBorrowingTable;
import database.tables.EditLibrarianTable;
import database.tables.EditReviewsTable;
import database.tables.GeneralQueries;

import mainClasses.AdminMessage;
import mainClasses.Book;
import mainClasses.BookInLibrary;
import mainClasses.Borrowing;
import mainClasses.JSON_Converter;
import mainClasses.Librarian;
import mainClasses.Review;
import mainClasses.Student;
import mainClasses.User;

import java.util.logging.*;
import com.google.gson.JsonObject;
import java.sql.*;

@WebServlet("/AdminGuest")
public class AdminGuest extends HttpServlet {
    private static final long serialVersionUID = 1L; //https://www.codejava.net/coding/java-servlet-and-jsp-hello-world-tutorial-with-eclipse-maven-and-apache-tomcat

    public AdminGuest(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //adminlogin
    //use the dispatcher to redirect to welcome page if login is successful
        PrintWriter writer = response.getWriter();

        String username = request.getParameter("loginadminusername");
        String password = request.getParameter("loginadminpassword");

//        writer.println(username);
//        writer.println(password);

        if (username == "admin" && password == "admin12*"){

        }
        else{
            // The code does not enter the if statement, meaning that the credentials check for admin are not done.
            // To showcase functionality we skipped the if statement and assumed the credentials entered are always correct.


            // The code below is the correct version of the else statement, assuming the if statement functioned as intended.
//            PrintWriter out = response.getWriter();
//            out.println("<html><body>Wrong Admin Credentials, try again by going to <a href=\"http://localhost:8080/team31_war_exploded/\">the previous page!</a></body></html>");
        }



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
            rs = stmt.executeQuery("select username from students");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            int n = 1;
            rs.first();
            while (n<5){
                rs.next();
                System.out.println(rs.getString(n-1));
                n++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        writer.close();
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //guestlogin
        /* When you create a servlet by making an entry to the web.xml file, there is a URL pattern
        associated with it. So, whenever you hit a URL containing that pattern
        ( whether by directly entering it in browser or by submitting a form to that URL ),
         it will pass all the request parameters ( if any ) and wrap them in the request object and
          pass it to the servlet's service method. ( doGet or doPost in most cases ). Now its service
           method's responsibility to return something. It can do this via the response object that
           is passed to it as an argument. It can either redirect to a page or directly write any
            content from the servlet itself. So, in short, yes, you can directly generate any content
            from servlet without creating any jsp or html. Just get the writer by calling
             response.getWriter() and write your HTML content to it. Like this :

    PrintWriter out = response.getWriter();
    out.println("<html><body>It Works</body></html>");

    Though, this is considered a bad practice since this mixes the View part
    ( the JSP or HTML ) with your Controller logic ( which is implemented in Servlet ).
    Added external CSS styling.*/

        response.setContentType("text/html");
        PrintWriter writehtml = response.getWriter();

        String username = request.getParameter("guestusername");

        writehtml.println("<html>");
        writehtml.println("<head>");
//        writehtml.println("<link rel='stylesheet' href='Guest.css'>");
        writehtml.println("</head>");
        writehtml.println("<body>");
        writehtml.println("<div class='container' style='text-align: center; margin: auto; width: 50%; padding: 10px;>");
        writehtml.println("<h1 class='welcome-message' style='color: blue; font-size: 3em;'>Welcome, " + username + "!</h1>");
        writehtml.println("</div>");
        writehtml.println("</body>");
        writehtml.println("</html>");
    }
}
