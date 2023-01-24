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

@WebServlet("/StudentLibrarian")
public class StudentLibrarian extends HttpServlet {
    private static final long serialVersionUID = 1L; //https://www.codejava.net/coding/java-servlet-and-jsp-hello-world-tutorial-with-eclipse-maven-and-apache-tomcat

    public StudentLibrarian(){
        super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//student
        PrintWriter writer = response.getWriter();

        String username = request.getParameter("loginusername");
        String password = request.getParameter("loginpassword");
//
//        writer.println(username);
//        writer.println(password);
//
        Student p = new Student();

        try {
            p = EditStudentsTable.databaseToStudent(username, password);
        } catch (SQLException e) {
            PrintWriter out = response.getWriter();
            out.println("<html><body>Wrong Credentials, try again by going to <a href=\"http://localhost:8080/team31_war_exploded/\">the previous page!</a></body></html>");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);

        }

//        String un = p.getPersonalpage();
//        writer.println(un);

        writer.close();
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//librarian
        PrintWriter writer = response.getWriter();

        String username = request.getParameter("loginusername");
        String password = request.getParameter("loginpassword");
//
//        writer.println(username);
//        writer.println(password);
//
        Student p = new Student();

        try {
            p = EditStudentsTable.databaseToStudent(username, password);
        } catch (SQLException e) {
            PrintWriter out = response.getWriter();
            out.println("<html><body>Wrong Credentials, try again by going to <a href=\"http://localhost:8080/team31_war_exploded/\">the previous page!</a></body></html>");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        // If the log-in fails then an exception is thrown meaning that the user will not see the
        // page created below, thus he/she will not have access to any sensitive information.

//        String un = p.getPersonalpage();
//        writer.println(un);
//        Testing to see if the login worked.


        writer.close();
        writer.flush();
    }
}
