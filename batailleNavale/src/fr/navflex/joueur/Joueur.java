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
    private Flotte flotte;
    private Grille grille;

    // Getter
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public Flotte getFlotte() { return flotte; }

    public Grille getGrille() { return grille; }

    // Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setFlotte(Flotte flotte) { this.flotte = flotte; }

    public void setGrille(Grille grille) { this.grille = grille; }

    // Constructeur
    public Joueur (int id,String nom, int ligne, int colonne) throws Exception
    {
        this.setId(id);
        this.setNom(nom);
        this.setFlotte(new Flotte(this.getId()));
        this.setGrille(new Grille(ligne, colonne));
    }

    // METHODES
    public void placerPorteAvion() {
        Navire porteAvion = new Navire(1,TypeNavire.PorteAvions, 5);
        int nbPointsAPlacer = porteAvion.getLongueur();

        for (int i = 0; i < nbPointsAPlacer ; i++)
        {
            Coordonnee coordonnee = new Coordonnee(0,0).saisirCoordonnee();
        }
    }
}
