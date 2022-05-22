package fr.navflex.modele.navire;

import fr.navflex.dao.DAONavire;
import java.util.ArrayList;

public class Flotte {
    // ATTRIBUTS
    private int id;
    private ArrayList<Navire> listeNavire;

    // CONSTRUCTEUR
    public Flotte(int id) // On lui passe en parametre le meme id que le joueur qui instancie la flotte
    {
        this.setListeNavire();
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
    private void setId(int id) {this.id = id;}
    private void setListeNavire() {
        this.listeNavire = DAONavire.getInstance().getAll();
    }

    // METHODES


    public Navire getNavireById(int id, ArrayList<Navire> listeNavire) throws IllegalArgumentException
    {
        if (this.getListeNavire().size() > 0 && id <= 5 )
        {
            for (Navire navire : listeNavire)
            {
                if (navire.getId() == id)
                    return navire;
            }
        }
        throw new IllegalArgumentException("Erreur : le navire [" + id + "] n'est pas dans la liste.");
    }

    public ArrayList<Navire> getListeNavireAPlacer()
    {
        ArrayList<Navire> listeNavireAPlacer = new ArrayList<>();
        for (Navire navire : this.getListeNavire())
        {
            if(!navire.getInGrille())
            {
                listeNavireAPlacer.add(navire);
            }
        }
        return listeNavireAPlacer;
    }


    @Override
    public String toString() {
        for (Navire navire : this.getListeNavire())
        {
            System.out.println(navire);
        }
        return "";
    }
}



