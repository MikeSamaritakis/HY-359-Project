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

@WebServlet()
public class StudentLibrarian extends HttpServlet {
    private static final long serialVersionUID = 1L; //https://www.codejava.net/coding/java-servlet-and-jsp-hello-world-tutorial-with-eclipse-maven-and-apache-tomcat

//    public StudentLibrarian(){
//        super();
//    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//student

        String username = request.getParameter("loginusername");
        String password = request.getParameter("loginpassword");

//
//        writer.println(username);
//        writer.println(password);
//
        Student p = new Student();
String page = "";
        try {
            p = EditStudentsTable.databaseToStudent(username, password);
        } catch (SQLException e) {
            page = "index.jsp";
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (p == null){
            page="index.jsp";
            RequestDispatcher dd =request.getRequestDispatcher(page);
            dd.forward(request,response);

        }
        // If the log-in fails then an exception is thrown meaning that the user will not see the
        // page created as a welcome user, thus he/she will not have access to any sensitive information.
         String updateemail = p.getEmail();
         String updatefirstname = p.getFirstname();
         String updatelastname =  p.getLastname();
        RequestDispatcher rd= request.getRequestDispatcher("/Student.html");
        rd.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//librarian


        String username = request.getParameter("loginusername");
        String password = request.getParameter("loginpassword");
//
//        writer.println(username);
//        writer.println(password);
//
        Librarian p = new Librarian();
String page = "";
        try {
            p = EditLibrarianTable.databaseToLibrarian(username, password);
        } catch (SQLException e) {
           page="index.jsp";
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        if (p == null){
           page="index.jsp";
           RequestDispatcher dd =request.getRequestDispatcher(page);
           dd.forward(request,response);

        }




        // If the log-in fails then an exception is thrown meaning that the user will not see the
        // page created as a welcome user, thus he/she will not have access to any sensitive information.
        response.sendRedirect("Librarian.html");



    }
}
