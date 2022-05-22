package fr.navflex.modele.joueur;

import fr.navflex.modele.grille.Coordonnee;
import fr.navflex.modele.grille.Grille;
import fr.navflex.modele.navire.Flotte;
import fr.navflex.modele.navire.Navire;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Joueur {

    // Attributs
    private int id;
    private String nom;
    private Flotte flotte;
    private Grille grille;
    private Navire navire;

    // Getter
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public Flotte getFlotte() { return flotte; }

    public Grille getGrille() { return grille; }

    public Navire getNavire() {
        return navire;
    }

    // Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setFlotte(Flotte flotte) {
        this.flotte = flotte;
    }

    public void setGrille(Grille grille) {
        this.grille = grille;
    }

    public void setNavire(Navire navire) {
        this.navire = navire;
    }

    // Constructeur
    public Joueur (int id,String nom, int ligne, int colonne) throws Exception
    {
        this.setId(id);
        this.setNom(nom);
        this.setFlotte(new Flotte(this.getId()));  // La Flotte du Joueur possède donc le meme ID que le Joueur
        this.setGrille(new Grille(ligne, colonne));
    }

    // METHODES


    public boolean saisirPositionDuNavire(int id) // Dev en cours
    {
        return true;
    }

    public void placerNavire(Navire navire, int axeX, int axeY)
    {

    }

    @Override
    public String toString() {
        System.out.println("Joueur [" + this.getId() + "] : " + this.getNom());
        return "" + this.getFlotte();
    }
}
