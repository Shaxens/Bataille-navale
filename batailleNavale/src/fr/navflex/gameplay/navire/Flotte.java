package fr.navflex.gameplay.navire;

import fr.navflex.gameplay.navire.Navire;
import fr.navflex.sql.MySqlNavire;

import java.util.ArrayList;

public class Flotte {
    // ATTRIBUTS
    private ArrayList<Navire> flotte;

    // CONSTRUCTEUR
    public Flotte() {
        this.setFlotte();
    }

    // GETTER
    public ArrayList<Navire> getFlotte() {
        return flotte;
    }

    // SETTER
    private void setFlotte() {
        this.flotte = MySqlNavire.getInstance().getAll();
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

// METHODES

