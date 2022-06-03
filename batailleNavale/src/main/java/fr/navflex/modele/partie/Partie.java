package fr.navflex.modele.partie;

import fr.navflex.controleur.JoueurControleur;
import fr.navflex.modele.joueur.Joueur;
import fr.navflex.vue.Moniteur;

import java.util.ArrayList;

public class Partie {
    // ATTRIBUTS
    int id;
    ArrayList<Joueur> listeJoueur;
    JoueurControleur joueurControleur;
    ArrayList<Tour> historique;
    Moniteur moniteur;

    // CONSTRUCTEUR
    public Partie(int id, ArrayList<Joueur> listeJoueur, ArrayList<Tour> historique) {
        this.setId(id);
        this.setListeJoueur(listeJoueur);
        this.setHistorique(historique);
    }

    // SETTERS
    public void setId(int id) {
        this.id = id;
    }

    public void setListeJoueur(ArrayList<Joueur> listeJoueur) {
        this.listeJoueur = listeJoueur;
    }

    public void setHistorique(ArrayList<Tour> historique) {
        this.historique = historique;
    }

    // GETTERS
    public int getId() {
        return id;
    }

    public ArrayList<Joueur> getListeJoueur() {
        return listeJoueur;
    }

    public ArrayList<Tour> getHistorique() {
        return historique;
    }
    // METHODES

}
