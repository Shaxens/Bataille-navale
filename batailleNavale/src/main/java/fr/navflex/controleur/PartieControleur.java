package fr.navflex.controleur;

import fr.navflex.modele.grille.Grille;
import fr.navflex.modele.joueur.Joueur;
import fr.navflex.modele.partie.Partie;
import fr.navflex.modele.partie.Tour;
import fr.navflex.modele.utils.RandomizerTools;
import fr.navflex.vue.Moniteur;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PartieControleur {
    // ATTRIBUTS
    private final Moniteur moniteur = new Moniteur();
    private final JoueurControleur controleur = new JoueurControleur();
    private final InputControleur inputControleur = new InputControleur();

    // METHODES
    private int initNombreJoueur()
    {
        moniteur.creerMessage("Veuillez selectionner le nombre de Joueur : ");
        int nombreJoueur = inputControleur.inputEntierPositif();
        while (nombreJoueur < 2)
        {
            if (nombreJoueur == 0) {
                moniteur.creerMessage("Si il n'y a aucun joueur on va s'ennuyer, faites un choix plus raisonnable :  ");
            }
            else if (nombreJoueur == 1) {
                moniteur.creerMessage("Ah bonne idee c'est valide ! un mode contre moi-meme arrive bientot !\nMais pour l'instant jouez plutot avec au moins un ami, combien serez-vous du coup ? :");
            }
            nombreJoueur = inputControleur.inputEntierPositif();
        }
        return nombreJoueur;
    }

    private Grille initGrille()
    {
        Grille grille;
        while (true)
        {
            try{
                moniteur.creerMessage("Veuillez parametrer la taille de la grille \nSaisissez le nombre de ligne : ");
                int nbLigne = inputControleur.inputEntierPositif();
                moniteur.creerMessage("Saisissez le nombre de colonne : ");
                int nbColonne = inputControleur.inputEntierPositif();
                grille = new Grille(nbLigne, nbColonne);
                return grille;
            } catch (Exception e)
            {
                moniteur.creerMessage(e.getMessage());
                continue;
            }
        }
    }

    public void configurerGrilleDesJoueurs(ArrayList<Joueur> listeJoueurs) throws Exception {
        for (Joueur joueur : listeJoueurs) {
            controleur.addJoueur(joueur); // On ajoute ici les joueurs au controleur
        }
        ArrayList<String> optionsPlacement = new ArrayList<>();
        optionsPlacement.add("[1] -> Placement au hasard");
        optionsPlacement.add("[2] -> Placement manuel");
        for (Joueur joueur : listeJoueurs) {
            moniteur.creerMessage("\n" + joueur.getNom() + " voulez vous placer vos navires au hasard ou manuellement ? ");
            for (String choix : optionsPlacement) {
                moniteur.creerMessage(choix);
            }
            int choixJoueur = inputControleur.inputChoixListeObjetSansId(optionsPlacement);
            if (choixJoueur == 1)
            {
                RandomizerTools randomizer = new RandomizerTools();
                randomizer.placementDesNaviresRandom(joueur);
            }
            else if (choixJoueur == 2)
            {
                while (joueur.getFlotte().getListeNavireAPlacer().size() > 0)
                {
                    controleur.placerNavire(joueur.getId());
                }
            }
            moniteur.afficherGrille(joueur);
            moniteur.afficherListeNavire(joueur.getFlotte().getListeNavireEnMer());
        }
    }

    public Partie configurerPartie() throws Exception {
        moniteur.creerMessage("\n| NOUVELLE PARTIE |\n");
        int nombreJoueur = initNombreJoueur();
        Grille grilleInitiale = initGrille();
        ArrayList<Joueur> listeJoueurs = new ArrayList<>();
        for (int i = 0; i < nombreJoueur ; i++) {
            moniteur.creerMessage("Joueur " + (i+1) + " saisissez votre nom : ");
            String nomJoueur = inputControleur.inputString();
            Grille grilleJoueur = new Grille(grilleInitiale.getAxeX(), grilleInitiale.getAxeY());
            listeJoueurs.add(new Joueur(i+1, nomJoueur, grilleJoueur));
        }
        moniteur.creerMessage("\nPartie initialisee, voici les amiraux qui s'y affrontent : ");
        for (int i = 0; i < nombreJoueur ; i++) {
            moniteur.creerMessage("" + listeJoueurs.get(i));
        }
        configurerGrilleDesJoueurs(listeJoueurs);
        return new Partie(1,listeJoueurs, new ArrayList<Tour>());
    }

    public boolean verifierDefaite(Joueur joueur)
    {
        if (joueur.getFlotte().getListeNavireEnMer().size() == 0)
        {
            return true;
        }
        return false;
    }

    public void supprimerJoueurVaincu()
    {
        int joueurElimine = -1;
        ArrayList<Joueur> listeJoueurs = controleur.getListeJoueur();
        for (int i = 0; i < listeJoueurs.size(); i++) {
            if (verifierDefaite(listeJoueurs.get(i)))
            {
                joueurElimine = i;
            }
        }
        if (joueurElimine > -1)
        {
            listeJoueurs.remove(joueurElimine);
        }
    }

    public void startPartie(Partie partie)
    {
        TourControleur tourControleur = new TourControleur(controleur.getListeJoueur()); // Le controleur doit forcement contenir des joueurs pour les transmettre au JoueurControleur de TourControleur
        while (controleur.getListeJoueur().size() >= 2) // Tant qu'il reste au moins 2 joueur en course
        {
            Tour tour = tourControleur.startNouveauTour(partie.getHistorique().size() + 1);
            partie.getHistorique().add(tour);
            supprimerJoueurVaincu();
        }

    }
}
