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

@WebServlet()
public class EditInfo extends HttpServlet {
    private static final long serialVersionUID = 1L; //https://www.codejava.net/coding/java-servlet-and-jsp-hello-world-tutorial-with-eclipse-maven-and-apache-tomcat

//    public EditInfo(){
//        super();
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//  Edit info for Students
        String username = request.getParameter("editusername");
        String password = request.getParameter("editpassword");
        String email = request.getParameter("editemail");
        String firstname = request.getParameter("editfirstname");
        String lastname = request.getParameter("editlastname");

        Student stu = new Student();
        try {
            stu = EditStudentsTable.databaseToStudent(username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String usernameog = stu.getUsername();

        if (username != null){
            try {
                EditStudentsTable.updateStudentusername(usernameog, username);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else if (password != null) {
            try {
                EditStudentsTable.updateStudentusername(usernameog, password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else if (email != null) {
            try {
                EditStudentsTable.updateStudentusername(usernameog, email);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else if (firstname != null) {
            try {
                EditStudentsTable.updateStudentusername(usernameog, firstname);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else if (lastname != null) {
            try {
                EditStudentsTable.updateStudentusername(usernameog, lastname);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//  Edit info for Librarians
        String username = request.getParameter("editusernamel");
        String password = request.getParameter("editpasswordl");
        String email = request.getParameter("editemaill");
        String firstname = request.getParameter("editfirstnamel");
        String lastname = request.getParameter("editlastnamel");

        Librarian lib = new Librarian();
        try {
            lib = EditLibrarianTable.databaseToLibrarian(username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String usernameog = lib.getUsername();

        if (username != null){
            try {
                EditStudentsTable.updateStudentusername(usernameog, username);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else if (password != null) {
            try {
                EditStudentsTable.updateStudentusername(usernameog, password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else if (email != null) {
            try {
                EditStudentsTable.updateStudentusername(usernameog, email);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else if (firstname != null) {
            try {
                EditStudentsTable.updateStudentusername(usernameog, firstname);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else if (lastname != null) {
            try {
                EditStudentsTable.updateStudentusername(usernameog, lastname);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
