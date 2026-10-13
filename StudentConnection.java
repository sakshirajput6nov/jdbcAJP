package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class StudentConnection {
    private final static String url = "jdbc:mysql://localhost:3306/servletCRUD";
    private static final String user = "root";
    private static final String pwd = "Rajput@123";

    public Connection getconnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, pwd);
            if (connection != null)
                return connection;
             else {
                System.out.println("Something is wrong in url,username, password");
                return null;
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
