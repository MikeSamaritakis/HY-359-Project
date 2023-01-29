package Servlets;

import database.tables.EditLibrarianTable;
import database.tables.EditStudentsTable;
import mainClasses.Librarian;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet()
public class AdminDeleteUser extends HttpServlet {
    private static final long serialVersionUID = 1L; //https://www.codejava.net/coding/java-servlet-and-jsp-hello-world-tutorial-with-eclipse-maven-and-apache-tomcat

//   public AdminDeleteUser(){
//       super();
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("userToBeDeleted");

            try {
                EditLibrarianTable.deleteLibrarian(username);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            try {
                EditStudentsTable.deleteStudent(username);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
