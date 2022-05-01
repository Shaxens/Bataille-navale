package fr.navflex.gameplay.navire;

import fr.navflex.gameplay.grille.Coordonnee;
import fr.navflex.gameplay.navire.Navire;
import fr.navflex.sql.MySqlNavire;

import java.util.ArrayList;

public class Flotte {
    // ATTRIBUTS
    private ArrayList<Navire> listeNavire;
    private int id;

    // CONSTRUCTEUR
    public Flotte(int id) {
        this.setFlotte();
        this.setId(id);
    }


    // GETTER
    public ArrayList<Navire> getFlotte() {
        return this.listeNavire;
    }

    public int getId()
    {
        return this.id;
    }


    // SETTER
    private void setFlotte() {
        this.listeNavire = new ArrayList<>();
    }

    private void setId(int id)
    {
        this.id = id;
    }

    // METHODES

    public boolean ajoutPossibleById(int id)
    {
        if (this.getFlotte().size() > 0) // Si la flotte possède déjà des navires on verifie ces conditions
        {
            for (Navire navireDejaPresent : this.getFlotte()) {
                if (id == navireDejaPresent.getId()) // Si l'id de navire correspond à l'id d'un Navire déja présent on renvoie un msg d'erreur
                {
                    System.out.println("Erreur : le " + navireDejaPresent.getType() + " d'id(" + navireDejaPresent.getId() + ") fait deja parti de la flotte " + this.getId());
                    return false;
                }
            }
        }
        return true;
    }

    // Methode qui permet d'ajouter un Navire dans la Flotte sans avoir de doublon
    // Paramètre : Int id ---> (id du Navire)
    // Retour : Boolean (pour faciliter TEST UNITAIRES)
    public boolean addNavire(int id) {
        ArrayList<Navire> allNavire = MySqlNavire.getInstance().getAll(); // On recup la liste des navire possible en bdd
        TypeNavire typeNavire = null;
        int longueur = 0;

        for (Navire navire : allNavire) { // On cherche a faire correspondre l'id' passé en parametre avec avec la bdd pour les bons attribut de ce navire
            if (navire.getId() == id) {
                typeNavire = navire.getType();
                longueur = navire.getLongueur();
            }
        }
        Navire navire = new Navire(id, typeNavire, longueur); // On créé  navire   un objet de Type navire avec les bons paramètres

        // VERIFS AVANT AJOUT
        if (this.getFlotte().size() > 0) // Si la flotte possède déjà des navires on verifie ces conditions
        {
            if (!this.ajoutPossibleById(id))
            {
                return false;
            }
        }
        // VERIFS REUSSI
        this.getFlotte().add(navire); // On ajoute le navire bien paramétré à la Flotte
        System.out.println("Ajout a la flotte " + this.getId() + " du " + navire + " avec succes.");
        return true; // RETOUR BOOLEAN A UTILISER POUR TEST UNITAIRE
    }

    public Navire getNavirebyId(int id) throws Exception
    {
        if (this.getFlotte().size() > 0 && id <= 5 )
        {
            for (Navire navire : this.getFlotte())
            {
                if (navire.getId() == id)
                    return navire;
            }
        }
        else if (this.getFlotte().size() > 0 && id > 5)
        {
            throw new Exception("Erreur : l'id(" + id + ") n'existe pas.");
        }
        else  if (this.getFlotte().size() == 0 && id <= 5)
        {
            throw new Exception("Erreur : la flotte " + this.getId() + " est vide.");
        }
        else  if (this.getFlotte().size() == 0 && id > 5)
        {
            throw new Exception("Erreur : la flotte " + this.getId() + " est vide et l'id(" + id + ") n'existe pas.");
        }
        return null;
    }

    @Override
    public String toString() {
        System.out.println("Flotte :");
        for (Navire navire : this.getFlotte())
        {
            System.out.println(navire);
        }
        return "Nombre de navire : " + this.getFlotte().size();
    }
}



