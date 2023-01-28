package database.tables;

import com.google.gson.Gson;
import database.DB_Connection;
import mainClasses.Admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EditAdminsTable extends Admin{

    public void createAdminTable() throws SQLException, ClassNotFoundException {

        Connection con = DB_Connection.getConnection();
        Statement stmt = con.createStatement();

        String query = "CREATE TABLE admins "
                + "(username char(255) , "
                + "   password char(255),"
                + " PRIMARY KEY ( username ))";
        stmt.execute(query);
        stmt.close();
        insertdefaultvalues();
    }

    public void insertdefaultvalues() {
        try {
            Connection con = null;
            try {
                con = DB_Connection.getConnection();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            Statement stmt = con.createStatement();

            String insertQuery = "INSERT INTO "
                    + " admins (USERNAME, PASSWORD)"
                    + " VALUES ('admin','admin12*')";
            //stmt.execute(table);
            System.out.println(insertQuery);
            stmt.executeUpdate(insertQuery);
            System.out.println("# The admin was successfully added in the database.");
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(EditAdminsTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Admin databaseToAdmin(String username, String password) throws SQLException, ClassNotFoundException{
        Connection con = DB_Connection.getConnection();
        Statement stmt = con.createStatement();

        ResultSet rs;
        try {
            rs = stmt.executeQuery("SELECT * FROM admins WHERE username = '" + username + "' AND password='"+password+"'");
            rs.next();
            String json=DB_Connection.getResultsToJSON(rs);
            Gson gson = new Gson();
            Admin admin = gson.fromJson(json, EditAdminsTable.class);
            return admin;
        } catch (Exception e) {
            System.out.println("Got an exception! ");
            System.err.println(e.getMessage());
            System.out.println("WRONG ADMIN CREDENTIALS!");
        }
        return null;
    }

}