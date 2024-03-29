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

    public void setFlotte(Flotte flotte) {
        this.flotte = flotte;
    }

    public void setGrille(Grille grille) {
        this.grille = grille;
    }

    // Constructeur
    public Joueur (int id,String nom, Grille grille) throws Exception
    {
        this.setId(id);
        this.setNom(nom);
        this.setFlotte(new Flotte(this.getId()));  // La Flotte du Joueur possède donc le meme ID que le Joueur
        this.setGrille(grille);
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
        return "[ " + this.getNom() + " ]";
    }
}
