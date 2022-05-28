package fr.navflex.modele.joueur;

import fr.navflex.modele.navire.Navire;
import fr.navflex.modele.navire.TypeNavire;

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

        if (navire.getType() == TypeNavire.PorteAvions) {
            double res = navire.getPosition().size() * 3.62;
            System.out.println(res);
            return res;
        } else if (navire.getType() == TypeNavire.Croiseur) {
            double res = navire.getPosition().size() * 2.48;
            System.out.println(res);
            return res;
        } else if (navire.getType() == TypeNavire.ContreTorpilleur) {
            double res = navire.getPosition().size() * 1.86;
            System.out.println(res);
            return res;
        } else if (navire.getType() == TypeNavire.Torpilleur) {
            double res = navire.getPosition().size() * 1.28;
            System.out.println(res);
            return res;
        } else {
            throw new Exception("Erreur de calcul du navire");
        }
    }
}
