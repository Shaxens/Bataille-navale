package fr.navflex.joueur;

import fr.navflex.gameplay.grille.Coordonnee;
import fr.navflex.gameplay.grille.Grille;
import fr.navflex.gameplay.navire.Flotte;
import fr.navflex.gameplay.navire.Navire;
import fr.navflex.gameplay.navire.TypeNavire;
import fr.navflex.sql.MySqlNavire;

import java.util.ArrayList;
import java.util.Scanner;

public class Joueur {

    // Attributs
    private int id;
    private String nom;
    private ArrayList<Navire> flotte;
    private Grille grille;

    // Getter
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public ArrayList<Navire> getFlotte() { return flotte; }

    public Grille getGrille() { return grille; }

    // Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setFlotte(ArrayList<Navire> flotte) { this.flotte = flotte; }

    public void setGrille(Grille grille) { this.grille = grille; }

    // Constructeur
    public Joueur (int id,String nom, int ligne, int colonne) throws Exception
    {
        this.setId(id);
        this.setNom(nom);
        this.setFlotte(new ArrayList<>());
        this.setGrille(new Grille(ligne, colonne));
    }

    // METHODES
    public void placerPorteAvion() throws Exception
    {
        Navire porteAvion = new Navire(1,TypeNavire.PorteAvions, 5);
        ArrayList<Coordonnee> position = new ArrayList<>();
        int nbPointsAPlacer = porteAvion.getLongueur();

        for (int i = 0; i < nbPointsAPlacer ; i++)
        {
            Scanner scan = new Scanner(System.in);
            int ligne = 0;
            int colonne = 0;
            System.out.println("Coordonnee " + i+1 + " :\n Entrez la ligne : ");
            try {
                ligne = scan.nextInt();
            } catch (Exception e)
            {
                System.out.println("Erreur : " + e);
            }

            System.out.println("Entrez la colonne : ");
            try {
                colonne = scan.nextInt();
            } catch (Exception e)
            {
                System.out.println("Erreur : " + e);
            }

            position.add(new Coordonnee(ligne, colonne));
            porteAvion.setPosition(position);
            porteAvion.setInFlotte(true);

            this.getFlotte().add(porteAvion);
        }
    }

}
