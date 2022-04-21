package sql;
import java.sql.*;

public class Connexion
{
    // ATTRIBUT
    private static Connexion instance;

    // Constructeur
    private Connexion() {
    }

    // METHODES
    public static Connexion getInstance() // On créé un singleton d'objet de type Connexion (une instance)
    {
        if (instance != null) {
            instance = new Connexion();
        }
        return instance;
    }

    public static Connection creeConnexion() //
    {
        String url = "jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/oury16u_batailleNavale";
        String login = "oury16u_appli";
        String pwd = "32124584";
        Connection maConnexion = null;

        try {
            maConnexion = DriverManager.getConnection(url, login, pwd);
        } catch (SQLException sqle) {
            System.out.println("Erreur connexion" + sqle.getMessage());
        }

        return maConnexion;
    }
}
