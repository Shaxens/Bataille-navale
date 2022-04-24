package sql;

import java.sql.*;
import gameplay.*;
import java.util.ArrayList;

import static sql.Connexion.creeConnexion;


public class MySqlNavire implements DAO<Navire>
{
    // ATTRIBUTS
    private Connexion connexion;
    private static MySqlNavire instance;

    // CONSTRUCTEUR
    private MySqlNavire()
    {
        this.connexion = Connexion.getInstance();
    }

    // INSTANCIATION de MySqlNavire  ---  On utilisera MySqlNavire.getInstance().uneMethode() à chaque fois que l'on veut l'utiliser
    public static MySqlNavire getInstance() // Cette Methode permet d'obtenir et d'utiliser un singleton d'instance MySqlNavire
    {
        if (instance == null) {
            instance = new MySqlNavire();
        }
        return instance;
    }

    // METHODES
    @Override
    public ArrayList<Navire> getAll() {
        try {
            Connection laConnexion = creeConnexion();
            PreparedStatement requete = laConnexion.prepareStatement("SELECT * FROM NAVIRE");
            ResultSet resultat = requete.executeQuery();
            ArrayList<Navire> flotte = new ArrayList<>();

            while (resultat.next()) {
                int id = resultat.getInt("id");
                TypeNavire type = TypeNavire.valueOf(resultat.getString("type"));
                int longueur = resultat.getInt("longueur");

                flotte.add(new Navire(id, type, longueur));
            }
            return flotte;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Navire getById(int id)
    {
        try {
            Connection laConnexion = creeConnexion();
            PreparedStatement requete = laConnexion.prepareStatement("SELECT * FROM NAVIRE");
            ResultSet resultat = requete.executeQuery();

            while (resultat.next()) {
                if (resultat.getInt("id") == id)
                {
                    int idNavire = resultat.getInt("id");
                    TypeNavire type = TypeNavire.valueOf(resultat.getString("type"));
                    int longueur = resultat.getInt("longueur");

                    return new Navire(idNavire, type, longueur);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
