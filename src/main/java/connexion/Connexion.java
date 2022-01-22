package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
	private static String login = "root";
    private static String password = "root";
    private static String url = "jdbc:mysql://localhost:8889/hotel?serverTimezone=UTC";
    private Connection connection = null;
    private static Connexion instane;

    public Connexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Driver introuvable");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connexion errror");
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static Connexion getInstane() {
        if (instane == null) {
            instane = new Connexion();
        }
        return instane;
    }

}
