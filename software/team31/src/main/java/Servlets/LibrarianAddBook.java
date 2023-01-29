package Servlets;

import database.tables.EditBooksTable;
import mainClasses.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet()
public class LibrarianAddBook extends HttpServlet {
    private static final long serialVersionUID = 1L; //https://www.codejava.net/coding/java-servlet-and-jsp-hello-world-tutorial-with-eclipse-maven-and-apache-tomcat

//    public LibrarianAddBook(){
//        super();
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Librarian can add a book to the library.
        Book book = new Book();
       String page="";
        String isbn = request.getParameter("newisbn");
        book.setIsbn(isbn);
        String title = request.getParameter("newtitle");
        book.setTitle(title);
        String authors = request.getParameter("newauthors");
        book.setAuthors(authors);
        String genre = request.getParameter("newgenre");
        book.setGenre(genre);
        String URL = request.getParameter("newURL");
        book.setUrl(URL);
        String photo = request.getParameter("newphoto");
        book.setPhoto(photo);
        String pages = request.getParameter("newpages");
        book.setPages(Integer.parseInt(pages));
        String publicationyear2 = request.getParameter("newpublicationyear");
        book.setPublicationyear(Integer.parseInt(publicationyear2));

        try {
            EditBooksTable.createNewBook(book);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("Librarian.html");
    }
    @Override()
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }}

