package Servlets;

import database.DB_Connection;
import database.tables.EditBooksInLibraryTable;
import database.tables.EditBorrowingTable;
import mainClasses.BookInLibrary;
import mainClasses.Borrowing;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet()
public class LibrarianUpdateStatus extends HttpServlet {
    private static final long serialVersionUID = 1L; //https://www.codejava.net/coding/java-servlet-and-jsp-hello-world-tutorial-with-eclipse-maven-and-apache-tomcat

//    public LibrarianUpdateStatus(){
//        super();
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    Change status librarian.
        BookInLibrary bil = new BookInLibrary();
        EditBooksInLibraryTable ebil = new EditBooksInLibraryTable();
        Borrowing b = new Borrowing();
        EditBorrowingTable eb = new EditBorrowingTable();

        String newStatus = request.getParameter("newstatus");

        if (newStatus == "available") {
            Connection con = null;
            try {
                con = DB_Connection.getConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            Statement stmt = null;
            try {
                stmt = con.createStatement();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            String updateQuery = "UPDATE borrowing SET status = 'successEnd'";

            try {
                stmt.executeUpdate(updateQuery);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else if (newStatus == "unavailable"){
            Connection con = null;
            try {
                con = DB_Connection.getConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            Statement stmt = null;
            try {
                stmt = con.createStatement();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            String updateQuery = "UPDATE borrowing SET status = 'borrowed'";

            try {
                stmt.executeUpdate(updateQuery);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
