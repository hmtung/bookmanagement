package utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


/**
 * The Class JDBCConnection.
 */
public class JDBCConnection {

    /**
     * Gets the connection.
     *
     * @return the connection
     */
    public Connection getConnection() {
        Properties properties = new Properties();
        InputStream resources = this.getClass().getClassLoader().getResourceAsStream("db.properties");
        try {
            properties.load(resources);
            String dbClass = properties.getProperty("class");
            String url = properties.getProperty("url");
            String user = properties.getProperty("username");
            String password = properties.getProperty("password");
            Class.forName(dbClass);

            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resources != null) {
                    resources.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * Close connection.
     *
     * @param connection the connection
     */
    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
        }
    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        Connection con = new JDBCConnection().getConnection();
        if (con != null) {
            System.out.println("Thanh cong");
            JDBCConnection.closeConnection(con);
        } else {
            System.out.println("That bai");
        }
    }
}
