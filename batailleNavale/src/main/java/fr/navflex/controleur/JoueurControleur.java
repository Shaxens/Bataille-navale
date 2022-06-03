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
    private final Moniteur moniteur;
    private final InputControleur inputControleur = new InputControleur();

    // CONSTRUCTEUR
    public JoueurControleur()
    {
        this.listeJoueur = new ArrayList<>();
        this.moniteur = new Moniteur();
    }

    // GETTERS
    public ArrayList<Joueur> getListeJoueur() {
        return listeJoueur;
    }

    public Moniteur getMoniteur() {
        return moniteur;
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

    public Navire selectionnerNavireAPlacer(int idJoueur) throws Exception
    {
        Joueur joueur = selectionnerJoueur(idJoueur);
        ArrayList<Navire> listeNavire = joueur.getFlotte().getListeNavireAPlacer();
        if (listeNavire.size() == 0) {throw new Exception("Tout vos navire sont deja en mer !");}
        this.moniteur.creerMessage("\n| Placement d'un navire |");
        this.moniteur.afficherListeNavire(listeNavire);
        this.moniteur.creerMessage("\nSelectionnez un navire [?] : ");
        int selectionNavire;

        while(true) {
            try {
                selectionNavire = inputControleur.inputEntier();
                Navire navire = joueur.getFlotte().getNavireByIdOnListe(selectionNavire, listeNavire);
                this.moniteur.creerMessage("\nVous avez selectionne : " + navire);
                return navire;
            } catch (IllegalArgumentException iae)
            {
                this.moniteur.creerMessage(iae.getMessage());
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
                this.moniteur.creerMessage("Saisissez la Coordonnee de depart");
                this.moniteur.creerMessage("position en X : ");
                int coordX = inputControleur.inputEntier();
                this.moniteur.creerMessage("position en Y : ");
                int coordY = inputControleur.inputEntier();
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
                this.moniteur.creerMessage(e.getMessage());
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
        this.moniteur.afficherGrille(joueur);
        while (true)
        {
            try
            {
                ArrayList<ArrayList<Coordonnee>> listePositionPossible = getListePositionPossibleAvecSaisieInitiale(idJoueur, navireAPlacer);
                this.moniteur.creerMessage("\nPosition possible depuis cette coordonnee :");
                this.moniteur.afficherListeObjetSansId(listePositionPossible);
                this.moniteur.creerMessage("Selectionnez la position voulue [?] : ");
                int choixUtilisateur = inputControleur.inputChoixListeObjetSansId(listePositionPossible);
                ArrayList<Coordonnee> positionChoisie = listePositionPossible.get(choixUtilisateur - 1);

                joueur.getGrille().placerNavireSurGrille(positionChoisie,navireAPlacer);
                this.moniteur.creerMessage("\nVotre navire est pret au combat !");
                this.moniteur.afficherGrille(joueur);
                this.moniteur.creerMessage("" + navireAPlacer);
                return true;
            } catch (IllegalArgumentException iae)
            {
                this.moniteur.creerMessage(iae.getMessage());
                continue;
            }
        }
    }

    public boolean faireFeu(int idJoueur, int idJoueurCible)
    {
        Joueur joueur = selectionnerJoueur(idJoueur);
        Joueur joueurCible = selectionnerJoueur(idJoueurCible);
        moniteur.creerMessage(joueur.getNom() + " vous attaquez " + joueurCible.getNom());
        moniteur.creerMessage("Ou souhaitez vous faire feu ? : ");
        while (true)
        {
            try
            {
                this.getMoniteur().creerMessage("Position en X : ");
                int coordX = inputControleur.inputEntier();
                this.getMoniteur().creerMessage("Position en Y : ");
                int coordY = inputControleur.inputEntier();
                Coordonnee coordonnee = new Coordonnee(coordX, coordY);
                int resultat = joueurCible.getGrille().faireFeuEn(coordonnee);
                if (resultat != 0)
                {
                    Navire navire = joueurCible.getFlotte().getNavireById(resultat);
                    navire.estToucheEn(coordonnee);
                    if (navire.getPointsVie() > 0)
                    {
                        moniteur.creerMessage("Boom ! touche !");
                    }
                    else
                    {
                        moniteur.creerMessage("Boom ! touche.. Coule !!!");
                    }
                }
                else
                {
                    moniteur.creerMessage("Plouf ! Aucun navire n'a ete touche");
                }
                return true;
            } catch (Exception e)
            {
                moniteur.creerMessage(e.getMessage());
                continue;
            }
        }
    }
}
