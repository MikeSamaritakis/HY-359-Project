package Servlets;

import com.google.gson.Gson;
import database.DB_Connection;
import database.tables.EditReviewsTable;
import database.tables.EditStudentsTable;
import mainClasses.Review;
import mainClasses.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet()
public class StudentReviewBook extends HttpServlet {
    private static final long serialVersionUID = 1L; //https://www.codejava.net/coding/java-servlet-and-jsp-hello-world-tutorial-with-eclipse-maven-and-apache-tomcat

    public StudentReviewBook(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Student submits review if he has already completed one borrowing of the book.
        String isbn = request.getParameter("reviewisbn");
        String score = request.getParameter("reviewscore");
        String review = request.getParameter("reviewbox");
        String username = request.getParameter("reviewusername");

        Student p = new Student();
        try {
            p = EditStudentsTable.databaseToStudent2(username);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        username = p.getStudent_id();

                EditReviewsTable editnewreview = new EditReviewsTable();
                Review newreview = new Review();

                newreview.setIsbn(isbn);
                newreview.setReviewScore(score);
                newreview.setReviewText(review);
                int a= 1;
                newreview.setUser_id(a);

        try {
            editnewreview.createNewReview(newreview);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("Student.html");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
