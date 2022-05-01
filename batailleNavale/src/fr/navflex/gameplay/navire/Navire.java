package fr.navflex.gameplay.navire;

import fr.navflex.gameplay.grille.Coordonnee;

import java.util.ArrayList;

public class Navire
{
    // Attributs
    private int id; // id du bateau issu de la bdd
    private TypeNavire type; // type du navire qui définira sa longueur (lien fait dans la bdd)
    private int longueur; // La longueur correspond au nombre de point du bateau à toucher
    private ArrayList<Coordonnee> position; // Un array de Coordonnée (une pour chaque point du bateau)
    private boolean inGrid; // False par default, passera à true lorsque le joueur place le bateau sur la grille
    private int pointsVie;

    // Constructeur
    public Navire(int id, TypeNavire type, int longueur)
    {
        this.setId(id);
        this.setType(type);
        this.setLongueur(longueur);
        this.position = new ArrayList<Coordonnee>();
        this.inGrid = false;
        this.setPointsVie();
    }

    // GETTERS
    public int getId() {
        return this.id;
    }
    public TypeNavire getType() {
        return this.type;
    }
    public int getLongueur() {
        return this.longueur;
    }
    public ArrayList<Coordonnee> getPosition() {
        return this.position;
    }
    public boolean getInGrid() {
        return this.inGrid;
    }
    public int getPointsVie() { return  this.pointsVie; }

    // SETTERS
    public void setId(int id) {
        this.id = id;
    }

    public void setType(TypeNavire type) {
        this.type = type;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public void setPosition(ArrayList<Coordonnee> position) {
        this.position = position;
    }

    public void setInGrid(boolean inGrid) {
        this.inGrid = inGrid;
    }

    public void setPointsVie() { this.pointsVie = this.getPosition().size(); }

    // METHODES
    @Override
    public String toString() {
        if (this.inGrid)
        {
            return "Navire " + id + " : " + type + " de longueur " + longueur + " en position " + position;
        }
        else
        {
            return "Navire " + id + " : " + type + " de longueur " + longueur;
        }
    }
}
