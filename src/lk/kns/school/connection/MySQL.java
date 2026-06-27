package lk.kns.school.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import lk.kns.school.util.ConfigLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQL {

    private static final Logger LOGGER = Logger.getLogger(MySQL.class.getName());
    private static Connection connection;

    public static Connection createConnection() {
        try {
            if (connection == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");

                String url = "jdbc:mysql://" + ConfigLoader.get("db.host") + ":" + ConfigLoader.get("db.port") + "/" + ConfigLoader.get("db.name");
                String user = ConfigLoader.get("db.user");
                String pass = ConfigLoader.get("db.password");

                connection = DriverManager.getConnection(url, user, pass);
                LOGGER.info("Database connection established successfully.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            LOGGER.log(Level.SEVERE, "Failed to connect to the database!", e);
        }
        return connection;
    }

    public static ResultSet execute(String query) throws SQLException {
        try {
            Statement smt = createConnection().createStatement();
            if (query.startsWith("SELECT")) {
                return smt.executeQuery(query);
            } else {
                smt.executeUpdate(query);
                return null;
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Query Execution Failed: " + query, e);
            throw e;
        }
    }

}
