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

@WebServlet(name = "Servlets.LoginWelcomeGuest", value = "/Servlets.LoginWelcomeGuest")
public class LoginWelcomeGuest extends HttpServlet {
    private static final long serialVersionUID = 1L; //https://www.codejava.net/coding/java-servlet-and-jsp-hello-world-tutorial-with-eclipse-maven-and-apache-tomcat

    public LoginWelcomeGuest(){
        super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
