package bl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utile {

    private static final String DB_BRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "postgres";

    public Connection getConnection () {
        Connection connection = null;

        try {
            Class.forName(DB_BRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connection is OK");

        }catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            System.out.println("Connection ERROR");
        }
        return connection;
    }


}
