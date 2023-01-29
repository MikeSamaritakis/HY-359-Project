package Servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;
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

@WebServlet()
public class StudentFindBook extends HttpServlet {
    private static final long serialVersionUID = 1L; //https://www.codejava.net/coding/java-servlet-and-jsp-hello-world-tutorial-with-eclipse-maven-and-apache-tomcat


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();


        //            DB_Connection.getConnection();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//
//
//        String  isbn = "";
//        String query = "SELECT isbn FROM books WHERE name='" + isbn + "'";
//
//        Statement stmt = null;
//        try {
//            stmt = DB_Connection.getConnection().createStatement();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        try {
//            stmt.executeUpdate(query);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        ResultSet rs;
//
//        try {
//            rs = stmt.executeQuery(query);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        try
//        {
//
//
//            rs = stmt.executeQuery(query);
//
//
//            while (rs.next())
//            {
//
//                String nm = rs.getString("isbn");
//
//
//            }
//
//
//        }
//        catch (Exception e)
//        {
//            out.println("error");
//        }
//

      String isbn = "";
      Book grepolis = new Book();
        try {
            EditBooksTable.databaseToBooksbyISBN(isbn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String grepolisTitle = grepolis.getTitle();
        out.print(grepolisTitle);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}