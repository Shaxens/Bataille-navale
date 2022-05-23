package fr.navflex.controleur;

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

    public Navire selectionnerNavireAPlacer(int idJoueur) throws Exception
    {
        Joueur joueur = selectionnerJoueur(idJoueur);
        ArrayList<Navire> listeNavire = joueur.getFlotte().getListeNavireAPlacer();
        if (listeNavire.size() == 0) {throw new Exception("Tout vos navire sont deja en mer !");}
        this.affichage.creerMessage("| Placement d'un navire |");
        this.affichage.afficherListeNavire(listeNavire);
        this.affichage.creerMessage("Selectionnez un navire [?] : ");
        Scanner input = new Scanner(System.in);
        int selectionNavire;

        while(true) {
            try {
                selectionNavire = input.nextInt();
                Navire navire = joueur.getFlotte().getNavireById(selectionNavire, listeNavire);
                this.affichage.creerMessage("Vous avez selectionne : " + navire);
                return navire;
            } catch (InputMismatchException ime) {
                String mauvaisChoix = input.next();
                this.affichage.creerMessage("Saisie invalide, veuillez saisir un entier : ");
                continue;
            } catch (IllegalArgumentException iae)
            {
                this.affichage.creerMessage(iae.getMessage() + " Veuillez saisir un navire present dans la liste : ");
                continue;
            }
        }
    }

    public void placerNavire(int idJoueur) throws Exception {
        Joueur joueur = selectionnerJoueur(idJoueur);
        Navire navireAPlacer;
        try {
            navireAPlacer = selectionnerNavireAPlacer(idJoueur);
        } catch (Exception e)
        {
            throw new Exception(e.getMessage());
        }
        this.affichage.afficherGrille(joueur);
        this.affichage.creerMessage("Saisissez la Coordonnee de depart\nPosition en X : ");


    }
}
