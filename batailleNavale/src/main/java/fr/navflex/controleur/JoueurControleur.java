package fr.navflex.controleur;

import fr.navflex.modele.grille.Coordonnee;
import fr.navflex.modele.joueur.Joueur;
import fr.navflex.modele.navire.Navire;
import fr.navflex.vue.Moniteur;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class JoueurControleur {
    // ATTRIBUTS
    private ArrayList<Joueur> listeJoueur;
    private final Moniteur affichage;

    // CONSTRUCTEUR
    public JoueurControleur()
    {
        this.listeJoueur = new ArrayList<>();
        this.affichage = new Moniteur();
    }

    // GETTERS
    public ArrayList<Joueur> getListeJoueur() {
        return listeJoueur;
    }

    public Moniteur getAffichage() {
        return affichage;
    }


    //  METHODES
    public void addJoueur(Joueur joueur)
    {
        this.listeJoueur.add(joueur);
    }

    public Joueur selectionnerJoueur(int idJoueur)
    {
        for (Joueur joueur : this.listeJoueur) {
            if (joueur.getId() == idJoueur)
            {
                return joueur;
            }
        }
        return null;
    }

    public int verifInputEntier()
    {
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException ime) {
                String mauvaisChoix = scanner.next();
                this.affichage.creerMessage("Erreur : Saisie invalide, veuillez saisir un entier : ");
                continue;
            }
        }
    }

    public int verifInputChoixListeObjetSansId(ArrayList liste)
    {
        while (true)
        {
            try {
                int choixDansListe = verifInputEntier();
                if (liste.size() < choixDansListe || choixDansListe > 1)
                {
                    throw new IllegalArgumentException("Erreur : " + choixDansListe + " n est pas une option de la liste.");
                }
                return choixDansListe;
            } catch (InputMismatchException | IllegalArgumentException ime) {
                this.affichage.creerMessage(ime.getMessage());
                continue;
            }
        }
    }

    public Navire selectionnerNavireAPlacer(int idJoueur) throws Exception
    {
        Joueur joueur = selectionnerJoueur(idJoueur);
        ArrayList<Navire> listeNavire = joueur.getFlotte().getListeNavireAPlacer();
        if (listeNavire.size() == 0) {throw new Exception("Tout vos navire sont deja en mer !");}
        this.affichage.creerMessage("\n| Placement d'un navire |");
        this.affichage.afficherListeNavire(listeNavire);
        this.affichage.creerMessage("\nSelectionnez un navire [?] : ");
        int selectionNavire;

        while(true) {
            try {
                selectionNavire = verifInputEntier();
                Navire navire = joueur.getFlotte().getNavireById(selectionNavire, listeNavire);
                this.affichage.creerMessage("\nVous avez selectionne : " + navire);
                return navire;
            } catch (IllegalArgumentException iae)
            {
                this.affichage.creerMessage(iae.getMessage());
                continue;
            }
        }
    }

    private ArrayList<ArrayList<Coordonnee>> getListePositionPossibleAvecSaisieInitiale(int idJoueur, Navire navireAPlacer)
    {
        Scanner input = new Scanner(System.in);
        Joueur joueur = this.selectionnerJoueur(idJoueur);
        ArrayList<ArrayList<Coordonnee>> listePositionPossible = new ArrayList<>();
        while(true) {
            try {
                this.affichage.creerMessage("Saisissez la Coordonnee de depart");
                this.affichage.creerMessage("position en X : ");
                int coordX = verifInputEntier();
                this.affichage.creerMessage("position en Y : ");
                int coordY = verifInputEntier();
                if (joueur.getGrille().estPlacable(new Coordonnee(coordX, coordY)))
                {
                    listePositionPossible = joueur.getGrille().getListePositionPossible(new Coordonnee(coordX,coordY),navireAPlacer);
                    if (listePositionPossible.size() > 0)
                    {
                        return listePositionPossible;
                    }
                    else
                    {
                        throw new IllegalArgumentException("Erreur : Coordonnee de depart invalide, elle ne permet aucun placement pour ce navire.");
                    }
                }
            } catch (Exception e) {
                this.affichage.creerMessage(e.getMessage());
                continue;
            }
        }
    }



    public boolean placerNavire(int idJoueur) throws Exception {
        Joueur joueur = selectionnerJoueur(idJoueur);
        Navire navireAPlacer;
        try {
            navireAPlacer = selectionnerNavireAPlacer(idJoueur);
        } catch (Exception e)
        {
            throw new Exception(e.getMessage());
        }
        this.affichage.afficherGrille(joueur);
        while (true)
        {
            try
            {
                ArrayList<ArrayList<Coordonnee>> listePositionPossible = getListePositionPossibleAvecSaisieInitiale(idJoueur, navireAPlacer);
                this.affichage.creerMessage("\nPosition possible depuis cette coordonnee :");
                this.affichage.afficherListeObjetSansId(listePositionPossible);
                this.affichage.creerMessage("Selectionnez la position voulue [?] : ");
                int choixUtilisateur = verifInputChoixListeObjetSansId(listePositionPossible);
                ArrayList<Coordonnee> positionChoisie = listePositionPossible.get(choixUtilisateur - 1);

                joueur.getGrille().placerNavireSurGrille(positionChoisie,navireAPlacer);
                this.affichage.creerMessage("\nVotre navire est pret au combat !");
                this.affichage.afficherGrille(joueur);
                this.affichage.creerMessage("" + navireAPlacer);
                return true;
            } catch (IllegalArgumentException iae)
            {
                this.affichage.creerMessage(iae.getMessage());
                continue;
            }
        }
    }
}
