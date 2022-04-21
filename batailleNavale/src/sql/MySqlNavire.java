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
            requete.setInt(1,id); // parameterIndex = 1 car on veut 'id' à la place du 1er '?'
            ResultSet res = requete.executeQuery();
            if (res.next())
            {
                int idEtu = res.getInt("id_etudiant");
                String ine = res.getString("ine_etudiant");
                String nom = res.getString("nom_etudiant");
                String prenom = res.getString("prenom_etudiant");
                String diplome = res.getString("diplome_etudiant");
                int idPromo = res.getInt("id_promotion");

                System.out.println(idEtu + " " + ine + " " + nom + " " + prenom + " " + diplome + " " + idPromo);
                instanceEtudiant = new Etudiant(ine,nom,prenom,idPromo);
                /*instanceEtudiant.setIne(ine);
                instanceEtudiant.setNom(nom);
                instanceEtudiant.setPrenom(prenom);
                instanceEtudiant.setIdPromo(idPromo);*/
            }
            if (res != null)
                res.close();
            if (requete != null)
                requete.close();
            if (laConnexion != null)
                laConnexion.close();
        } catch (SQLException sqle) {
            System.out.println("Pb select " + sqle.getMessage());
        }
        return instanceEtudiant;

        return null;
    }
}
