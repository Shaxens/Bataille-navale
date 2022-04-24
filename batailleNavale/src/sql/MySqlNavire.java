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

    public static MySqlNavire getInstance() {
        if (instance == null) {
            instance = new MySqlNavire();
        }
        return instance;
    }

    // METHODES
    @Override
    public ArrayList<Navire> getAll()
    {
        try
        {
            Connection laConnexion = creeConnexion();
            PreparedStatement requete = laConnexion.prepareStatement("SELECT * FROM NAVIRE");
            ResultSet res = requete.executeQuery();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
