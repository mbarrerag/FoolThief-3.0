package persistence;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.*;

public class Mysqlconnect {

    public void connectToDataBase() {

        String usuario = "root";
        String clave = "";
        String url = "jdbc:mysql://localhost:3306/database";
        Connection con;
        Statement stmt;
        ResultSet rs;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Mysqlconnect.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            con = DriverManager.getConnection(url, usuario, clave);
            stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO reportes VALUES (null,'Mary','06/16/2022','23:00','chapinero','Computador','Asalto a mano armada ','Cerca a la avenida caracas','Estaba solo cuando me llegaron 4 hombres')");
        } catch (SQLException ex) {
            Logger.getLogger(Mysqlconnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
