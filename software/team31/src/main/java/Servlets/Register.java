package Servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

import mainClasses.Librarian;
import mainClasses.Student;
import database.tables.EditStudentsTable;
import database.tables.EditLibrarianTable;

@WebServlet(name = "Servlets.Register", value = "/Servlets.Register")
public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L; //https://www.codejava.net/coding/java-servlet-and-jsp-hello-world-tutorial-with-eclipse-maven-and-apache-tomcat

    public Register(){
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();

        EditStudentsTable eut = new EditStudentsTable();
        Student student = new Student();

        String username = request.getParameter("Username");
        student.setUsername(username);
        String password = request.getParameter("Password");
        student.setPassword(password);
        String email = request.getParameter("Email");
        student.setEmail(email);
        String firstname = request.getParameter("Firstname");
        student.setFirstname(firstname);
        String lastname = request.getParameter("Lastname");
        student.setLastname(lastname);
        String birthdate = request.getParameter("Birthdate");
        student.setBirthdate(birthdate);
        String gender = request.getParameter("Gender");
        student.setGender(gender);
        String country = request.getParameter("Country");
        student.setCountry(country);
        String city = request.getParameter("City");
        student.setCity(city);
        String address = request.getParameter("Address");
        student.setAddress(address);
        Double lat = 0.00;
        student.setLat(lat);
        Double lon = 0.00;
        student.setLon(lon);
        String telephone = request.getParameter("Telephone");
        student.setTelephone(telephone);
        String personalpage = request.getParameter("Personalpage");
        student.setPersonalpage(personalpage);

        String student_id = request.getParameter("Student_id");
        String university = request.getParameter("University");
        String department = request.getParameter("Department");
        String student_type = request.getParameter("Student_type");
        String student_id_from_date = request.getParameter("Student_id_from_date");
        String student_id_to_date = request.getParameter("Student_id_to_date");

        student.setStudent_id(student_id);
        student.setDepartment(department);
        student.setUniversity(university);
        student.setStudent_type(student_type);
        student.setStudent_id_from_date(student_id_from_date);
        student.setStudent_id_to_date(student_id_to_date);

        try {
            eut.addNewStudent(student);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        writer.println("Registration was successful here are your data:");
        writer.println("Username: ");
        writer.println(username);
        writer.println("Email: ");
        writer.println(email);
        writer.println("Password: ");
        writer.println(password);
        writer.println("First Name: ");
        writer.println(firstname);
        writer.println("Last Name: ");
        writer.println(lastname);
        writer.println("To log into your account go to the previous page and use the Login button!");
        writer.flush();
        writer.close();

//----------------------------------------------------------------------------------------------//

        EditLibrarianTable lib = new EditLibrarianTable();
        Librarian librarian = new Librarian();

        librarian.setUsername(username);
        librarian.setPassword(password);
        librarian.setEmail(email);
        librarian.setFirstname(firstname);
        librarian.setLastname(lastname);
        librarian.setBirthdate(birthdate);
        librarian.setGender(gender);
        librarian.setCountry(country);
        librarian.setCity(city);
        librarian.setAddress(address);
        librarian.setLat(lat);
        librarian.setLon(lon);
        librarian.setTelephone(telephone);
        librarian.setPersonalpage(personalpage);

        String library_name = request.getParameter("Libraryname");
        librarian.setLibraryname(library_name);
        String library_info = request.getParameter("Libraryinfo");
        librarian.setLibraryinfo(library_info);

        if (library_info != "") {
            try {
                lib.addNewLibrarian(librarian);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        writer.println("Registration was successful here are your data:");
        writer.println("Username: ");
        writer.println(username);
        writer.println("Email: ");
        writer.println(email);
        writer.println("Password: ");
        writer.println(password);
        writer.println("First Name: ");
        writer.println(firstname);
        writer.println("Last Name: ");
        writer.println(lastname);
        writer.println("To log into your account go to the previous page and use the Login button!");

        writer.flush();

        writer.close();

        }
}