package lk.kns.school.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import lk.kns.school.util.ConfigLoader;

public class MySQL {

    private static Connection connection;

    public static Connection createConnection() {
        try {
            if (connection == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");

                String url = "jdbc:mysql://" + ConfigLoader.get("db.host") + ":" + ConfigLoader.get("db.port") + "/" + ConfigLoader.get("db.name");
                String user = ConfigLoader.get("db.user");
                String pass = ConfigLoader.get("db.password");

                connection = DriverManager.getConnection(url, user, pass);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static ResultSet execute(String query) throws SQLException {
        Statement smt = createConnection().createStatement();
        if (query.startsWith("SELECT")) {
            return smt.executeQuery(query);
        } else {
            smt.executeUpdate(query);
            return null;
        }
    }

}
