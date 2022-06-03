package fr.navflex.modele.partie;

import fr.navflex.controleur.JoueurControleur;
import fr.navflex.modele.joueur.Joueur;

import java.util.ArrayList;

public class Tour {

    // Attributs
    private int numeroTour;
    private ArrayList<Joueur> sauvegardeEtatsJoueurs;

    // CONSTRUCTEUR
    public Tour(int numeroTour, ArrayList<Joueur> sauvegardeEtatsJoueurs) {
        this.setNumeroTour(numeroTour);
        this.setSauvegardeEtatsJoueurs(sauvegardeEtatsJoueurs);
    }

    // SETTERS
    public void setNumeroTour(int numeroTour) {
        this.numeroTour = numeroTour;
    }

    public void setSauvegardeEtatsJoueurs(ArrayList<Joueur> sauvegardeEtatsJoueurs)
    {
        this.sauvegardeEtatsJoueurs = sauvegardeEtatsJoueurs;
    }

    // GETTERS
    public int getNumeroTour() {
        return numeroTour;
    }

    public ArrayList<Joueur> getSauvegardeEtatsJoueurs()
    {
        return this.sauvegardeEtatsJoueurs;
    }

    // METHODES

}
