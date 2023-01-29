package Servlets;

import com.google.gson.Gson;
import database.DB_Connection;
import database.tables.EditReviewsTable;
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

        ResultSet rs;
        try {
            rs = stmt.executeQuery("SELECT * FROM students WHERE username = '" + username + "'");
            rs.next();
            String json = DB_Connection.getResultsToJSON(rs);
            Gson gson = new Gson();
            Student user = gson.fromJson(json, Student.class);
            String user_id = user.getStudent_id();

            EditReviewsTable editnewreview = new EditReviewsTable();
            Review newreview = new Review();

            newreview.setIsbn(isbn);
            newreview.setReviewScore(score);
            newreview.setReviewText(review);
            newreview.setUser_id(Integer.parseInt(user_id));

            if (review != "") {
                try {
                    editnewreview.createNewReview(newreview);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (Exception e) {
            System.out.println("Username does not exist!");
            System.err.println(e.getMessage());

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
