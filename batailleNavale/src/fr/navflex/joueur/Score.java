package fr.navflex.joueur;

import java.util.ArrayList;
import fr.navflex.gameplay.navire.Navire;

public class Score {

    // Méthodes

    public double calculScore(Navire navire) {
        double res = navire.getPosition().size() * 3.62 ;
        System.out.println(res);
        return res;
    }
}
