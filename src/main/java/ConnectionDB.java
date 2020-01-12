import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Пробный класс для коннекшена
 * */

public class ConnectionDB {
    static final String USER = "postgres";
    static final String PASS = "root";
    static final String DATABASE_URL = "jdbc:postgresql://127.0.0.1:5432/testbase";

    private ConnectionDB() {
    }

    public static Connection getConnection (){

        Connection connection = null;

        try {
            connection = DriverManager
                    .getConnection(DATABASE_URL, USER, PASS);

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }
        if (connection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }

        return connection;
    }

}
