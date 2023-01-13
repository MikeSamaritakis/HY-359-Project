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

@WebServlet("/LoginWelcomeGuest")
public class LoginWelcomeGuest extends HttpServlet {
    private static final long serialVersionUID = 1L; //https://www.codejava.net/coding/java-servlet-and-jsp-hello-world-tutorial-with-eclipse-maven-and-apache-tomcat

    public LoginWelcomeGuest(){
        super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* When you create a servlet by making an entry to the web.xml file, there is a URL pattern
        associated with it. So, whenever you hit a URL containing that pattern
        ( wither by directly entering it in browser or by submitting a form to that URL ),
         it will pass all the request parameters ( if any ) and wrap them in the request object and
          pass it to the servlet's service method. ( doGet or doPost in most cases ). Now its service
           method's responsibility to return something. It can do this via the response object that
           is passed to it as an argument. It can either redirect to a page or directly write any
            content from the servlet itself. So, in short, yes, you can directly generate any content
            from servlet without creating any jsp or html. Just get the writer by calling
             response.getWriter() and write your HTML content to it. Like this :

    PrintWriter out = response.getWriter(); out.println("<html>");
    out.println("<html><body>It Works</body></html>");

    Though, this is considered a bad practice since this mixes the View part
    ( the JSP or HTML ) with your Controller logic ( which is implemented in Servlet ). */


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println("GUEST");
    }
}
