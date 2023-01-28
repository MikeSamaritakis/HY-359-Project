package mainClasses;

import database.DB_Connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateAdmin {
    String username, password;

    public String getUsername() {
        return username;
    }

    public void setMessage_id(String username2) {
        this.username = username2;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password2) {
        this.password = password2;
    }


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
            Logger.getLogger(CreateAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}