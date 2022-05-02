package fr.navflex.gameplay.navire;

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
    public ArrayList<Navire> getListeNavire() {
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

    public boolean ajoutPossibleById(int id) throws Exception
    {
        if (this.getListeNavire().size() > 0) // Si la flotte possède déjà des navires on verifie ces conditions
        {
            for (Navire navireDejaPresent : this.getListeNavire())
            {
                if (id == navireDejaPresent.getId()) // Si l'id de navire correspond à l'id d'un Navire déja présent on renvoie un msg d'erreur
                {
                    throw new Exception("Erreur : le " + navireDejaPresent.getType() + " d'id(" + navireDejaPresent.getId() + ") fait deja parti de la flotte " + this.getId());
                }
            }
        }
        return true;
    }

    // Methode qui permet d'ajouter un Navire dans la Flotte sans avoir de doublon
    // Paramètre : Navire navire ---> Le navire que l'on veut ajouter
    // Retour : Boolean (pour faciliter TEST UNITAIRES)
    public boolean addNavire(Navire navire) {
        try
        {
            this.ajoutPossibleById(navire.getId());
            this.getListeNavire().add(navire);

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        System.out.println("Ajout de : " + navire + " effectue avec succes.");
        return true;
    }


    public Navire getNavirebyId(int id) throws Exception
    {
        if (this.getListeNavire().size() > 0 && id <= 5 )
        {
            for (Navire navire : this.getListeNavire())
            {
                if (navire.getId() == id)
                    return navire;
            }
        }
        else if (this.getListeNavire().size() > 0 && id > 5)
        {
            throw new Exception("Erreur : l'id(" + id + ") n'existe pas.");
        }
        else  if (this.getListeNavire().size() == 0 && id <= 5)
        {
            throw new Exception("Erreur : la flotte " + this.getId() + " est vide.");
        }
        else  if (this.getListeNavire().size() == 0 && id > 5)
        {
            throw new Exception("Erreur : la flotte " + this.getId() + " est vide et l'id(" + id + ") n'existe pas.");
        }
        return null;
    }

    @Override
    public String toString() {
        System.out.println("Flotte :");
        for (Navire navire : this.getListeNavire())
        {
            System.out.println(navire);
        }
        return "Nombre de navire : " + this.getListeNavire().size();
    }
}



