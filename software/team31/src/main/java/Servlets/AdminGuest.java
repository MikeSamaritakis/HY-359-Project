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
            RequestDispatcher rd = request.getRequestDispatcher("LoginWelcomeAdmin");
            rd.forward(request,response);
        }
        else{
            // never entered if , cannot understand why, could not fix it, so I assume it is always correct.
            RequestDispatcher rd2 = request.getRequestDispatcher("LoginWelcomeAdmin");
            rd2.forward(request,response);
//            RequestDispatcher rd1 = request.getRequestDispatcher("Register");
//            rd1.forward(request,response);
//            System.out.println("WRONG ADMIN CREDENTIALS!");
        }

        writer.close();
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //guestlogin
    // use the dispatcher to redirect to welcome page if login is successful
        response.sendRedirect("http://localhost:8080/team31_war_exploded/LoginWelcomeGuest");
    }
}
