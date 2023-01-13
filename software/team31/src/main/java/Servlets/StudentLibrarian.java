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

        String username = request.getParameter("USERNAME");
        String password = request.getParameter("PASSWORD");

        writer.println(username);
        writer.println(password);

//        Student p = new Student();
//        try {
//            p = EditStudentsTable.databaseToStudent(username,password);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//
//        String un = p.getUsername();
//        writer.println(un);

        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//librarian
        PrintWriter writer = response.getWriter();

        String username = request.getParameter("USERNAME");
        String password = request.getParameter("PASSWORD");

        writer.println(username);
        writer.println(password);

//        Student p = new Student();
//        try {
//            p = EditStudentsTable.databaseToStudent(username,password);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//
//        String un = p.getUsername();
//        writer.println(un);

        writer.close();
    }
}
