package fr.navflex.controleur;

import fr.navflex.modele.joueur.Joueur;
import fr.navflex.modele.partie.Tour;
import fr.navflex.vue.Moniteur;

import java.util.ArrayList;

public class TourControleur {
    // ATTRIBUTS
    Moniteur moniteur = new Moniteur();
    JoueurControleur joueurControleur;
    InputControleur inputControleur = new InputControleur();

    // CONSTRUCTEUR
    public TourControleur(ArrayList<Joueur> listeJoueurs) {
        this.setJoueurControleur(listeJoueurs);
    }

    // SETTERS
    public void setJoueurControleur(ArrayList<Joueur> listeJoueurs) {
        this.joueurControleur = new JoueurControleur();
        for (Joueur joueur : listeJoueurs) {
            joueurControleur.addJoueur(joueur);
        }
    }

    // GETTERS
    public JoueurControleur getJoueurControleur() {
        return joueurControleur;
    }

    // METHODES
    public Tour startNouveauTour(int numeroTour)
    {
        ArrayList<Joueur> listeJoueurs = joueurControleur.getListeJoueur();
        moniteur.creerMessage("\n| Tour " + numeroTour + " |");
        for (Joueur joueurAttaquant : listeJoueurs) {
            ArrayList<Joueur> listeJoueurAAttaquer = new ArrayList<>();
            for (Joueur joueurAttaquable : listeJoueurs) {
                if (joueurAttaquable.getId() != joueurAttaquant.getId())
                {
                    listeJoueurAAttaquer.add(joueurAttaquable);
                }
            }
            moniteur.creerMessage( "\n" + joueurAttaquant.getNom() + " choisissez quel joueur attaquer : ");
            moniteur.afficherListeObjetSansId(listeJoueurAAttaquer);
            int choix = inputControleur.inputChoixListeObjetSansId(listeJoueurAAttaquer);
            Joueur joueurCible = listeJoueurAAttaquer.get(choix-1); // On soustrait 1 car lors de l'affichage on ajoute 1 pour éviter d'avoir un [0] comme choix
            joueurControleur.faireFeu(joueurAttaquant.getId(), joueurCible.getId());
        }
        moniteur.creerMessage("\nFin du tour.");
        return new Tour(numeroTour, joueurControleur.getListeJoueur());
    }
}
