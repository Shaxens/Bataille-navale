package fr.navflex.controleur;

import fr.navflex.modele.joueur.Joueur;
import fr.navflex.modele.navire.Navire;
import fr.navflex.vue.PartieVue;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class JoueurControleur extends PartieVue {
    // ATTRIBUTS
    private ArrayList<Joueur> listeJoueur;
    private final PartieVue affichage;

    // CONSTRUCTEUR
    public JoueurControleur()
    {
        this.listeJoueur = new ArrayList<>();
        this.affichage = new PartieVue();
    }


    //  METHODES
    public void addJoueur(Joueur joueur)
    {
        this.listeJoueur.add(joueur);

    }

    public Joueur selectionJoueur(int idJoueur)
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
        Joueur joueur = selectionJoueur(idJoueur);
        ArrayList<Navire> listeNavire = joueur.getFlotte().getListeNavireAPlacer();
        if (listeNavire.size() == 0) {throw new Exception("Tout vos navire sont deja en mer !");}
        System.out.println("| Placement d'un navire |");
        this.affichage.afficherListeNavire(listeNavire);
        System.out.println("Selectionnez un navire [?] : ");
        Scanner input = new Scanner(System.in);
        int selectionNavire;

        while(true) {
            try {
                selectionNavire = input.nextInt();
                Navire navire = joueur.getFlotte().getNavireById(selectionNavire, listeNavire);
                System.out.println("Vous avez selectionne : " + navire);
                return navire;
            } catch (InputMismatchException ime) {
                String mauvaisChoix = input.next();
                System.out.println("Saisie invalide, veuillez saisir un entier : ");
                continue;
            } catch (IllegalArgumentException iae)
            {
                System.out.println(iae.getMessage() + " Veuillez saisir un navire present dans la liste : ");
                continue;
            }
        }
    }
}
