package lk.kns.school.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQL {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "FHMNx35888#";
    private static final String DATABASE = "school_manager";

    private static Connection connection;

    public static Connection createConnection() {
        try {
            if (connection == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DATABASE, USERNAME, PASSWORD);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    
    
    public static ResultSet execute(String query)throws SQLException{
        Statement smt;
        if(query.startsWith("SELECT")){
            smt = createConnection().createStatement();
            return smt.executeQuery(query);
        }else{
            smt = createConnection().createStatement();
            smt.executeUpdate(query);
            return null;
        }
    }

}
