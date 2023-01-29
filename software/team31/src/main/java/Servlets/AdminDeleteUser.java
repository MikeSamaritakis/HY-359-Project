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
        String type = request.getParameter("TypeDelete");
        PrintWriter out = response.getWriter();
        out.println(type);
        out.println(username);
        if (type == "1"){
            try {
                EditLibrarianTable.deleteLibrarian(username);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        else if (type == "2"){
            try {
                EditStudentsTable.deleteStudent(username);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        else if (type == "0"){
            System.out.println("No user type selected.");
            System.err.println("Error occurred, not type selected by admin.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
