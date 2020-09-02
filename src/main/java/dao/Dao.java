package dao;

import util.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Dao {
    protected static Connection con;

    //constructor
    public Dao() {
        if (con == null) {
            try {
                con = new JDBCConnection().getConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void closeFunction(PreparedStatement ps, ResultSet rs) {
        try {
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void closePreparedStatement(PreparedStatement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (Exception e) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
