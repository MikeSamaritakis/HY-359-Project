package Servlets;

import database.tables.EditBooksInLibraryTable;
import database.tables.EditBorrowingTable;
import mainClasses.BookInLibrary;
import mainClasses.Borrowing;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

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


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
