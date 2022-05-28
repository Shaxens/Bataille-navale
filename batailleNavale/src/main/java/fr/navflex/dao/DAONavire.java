package fr.navflex.dao;

import java.sql.*;

import fr.navflex.modele.navire.Navire;
import fr.navflex.modele.navire.TypeNavire;

import java.util.ArrayList;


public class DAONavire implements DAOFactory<Navire>
{
    // ATTRIBUTS
    private Connexion connexion;
    private static DAONavire instance;

    // CONSTRUCTEUR
    private DAONavire()
    {
        this.connexion = Connexion.getInstance();
    }

    // INSTANCIATION de MySqlNavire  ---  On utilisera DAONavire.getInstance().uneMethode() à chaque fois que l'on veut l'utiliser
    public static DAONavire getInstance() // Cette Methode permet d'obtenir et d'utiliser un singleton d'instance MySqlNavire
    {
        if (instance == null) {
            instance = new DAONavire();
        }
        return instance;
    }

    // METHODES
    @Override
    public ArrayList<Navire> getAll() {
        try {
            Connection laConnexion = Connexion.creeConnexion();
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
            Connection laConnexion = Connexion.creeConnexion();
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
