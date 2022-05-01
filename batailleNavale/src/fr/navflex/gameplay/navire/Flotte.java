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
    // Paramètre : TypeNavire ---> (TypeNavire du Navire)
    // Retour : Boolean (pour faciliter TEST UNITAIRES)
    public boolean addNavire(TypeNavire typeNavire) {
        ArrayList<Navire> allNavire = MySqlNavire.getInstance().getAll(); // On recup la liste des navire possible en bdd
        int id = 0;
        int longueur = 0;

        for (Navire navire : allNavire) { // On cherche a faire correspondre le typeNavire passé en parametre avec avec la bdd pour récup le bon id
            if (navire.getType() == typeNavire) {
                id = navire.getId(); // ATTENTION si le navire est un contre-torpilleur, id = 3 puis id = 4 (car il y en a 2 en bdd, on revient sur ce problème dans les verif)
                longueur = navire.getLongueur();
            }
        }
        Navire navire = new Navire(id, typeNavire, longueur); // On créé  navire   un objet de Type navire avec les bons paramètres sauf pour le contre-torpilleur

        // On gère donc le cas du contre-torpilleur
        if (navire.getType() == TypeNavire.ContreTorpilleur)
        {
            navire.setId(3); // On passe l'id de navire à 3 par défaut (celui du premier contre-torpilleur)

            if(!this.ajoutPossibleById(3))// Si un Navire deja présent possède l'id 3
            {
                navire.setId(4); // On le remet à 4
            }
            else if (!this.ajoutPossibleById(4))// ENSUITE Si un Navire deja présent l'id 4
            {
                System.out.println("Erreur : Cette flotte comprend deja 2 contre-torpilleur."); // En envoie msg d'erreur
            return false;
            }
    }
            // Si c'était le premier il reste donc a 3


        // VERIFS AVANT AJOUT
        if (this.getFlotte().size() > 0) // Si la flotte possède déjà des navires on verifie ces conditions
        {
            for (Navire navireDejaPresent : this.getFlotte())
            {
                if (navire.getId() == navireDejaPresent.getId()) // Si l'id de navire correspond à l'id d'un Navire déja présent on renvoie un msg d'erreur
                {
                    System.out.println("Erreur : le " + navire.getType() + " d'id(" + navire.getId() + ") fait deja parti de la flotte " + this.getId());
                    return false;
                }
            }
        }

        // VERIFS REUSSI
        this.getFlotte().add(navire); // On ajoute le navire bien paramétré à la Flotte
        System.out.println("Ajout a la flotte " + this.getId() + " du " + navire + " avec succes.");
        return true; // RETOUR BOOLEAN A UTILISER POUR TEST UNITAIRE
    }



    // METHODES

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



