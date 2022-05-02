package main.java.fr.navflex.joueur;

import main.java.fr.navflex.gameplay.navire.Navire;

import static main.java.fr.navflex.gameplay.navire.TypeNavire.*;

public class Score {

    // Attributs
    double score = 0;

    // Getter
    public double getScore() {
        return score;
    }

    // Setter
    public void setScore(double score) {
        this.score = score;
    }

    // Constructeur
    public Score(double valeur) throws Exception {
        score = valeur;
    }

    // Méthodes
    public double calculScoreNavire(Navire navire) throws Exception {

        if (navire.getType() == PorteAvions) {
            double res = navire.getPosition().size() * 3.62;
            System.out.println(res);
            return res;
        } else if (navire.getType() == Croiseur) {
            double res = navire.getPosition().size() * 2.48;
            System.out.println(res);
            return res;
        } else if (navire.getType() == ContreTorpilleur) {
            double res = navire.getPosition().size() * 1.86;
            System.out.println(res);
            return res;
        } else if (navire.getType() == Torpilleur) {
            double res = navire.getPosition().size() * 1.28;
            System.out.println(res);
            return res;
        } else {
            throw new Exception("Erreur de calcul du navire");
        }
    }
}
