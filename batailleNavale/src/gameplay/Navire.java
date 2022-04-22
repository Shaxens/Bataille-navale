package gameplay;

import gameplay.Coordonnee;

import java.util.ArrayList;

public class Navire
{
    // Attributs
    private int id; // id du bateau issu de la bdd
    private TypeNavire type; // type du navire qui définira sa longueur (lien fait dans la bdd)
    private int longueur; // La longueur correspond au nombre de point du bateau à toucher
    private ArrayList<Coordonnee> position; // Un array de Coordonnée (une pour chaque point du bateau)
    private boolean inFlotte; // False par default, passera à true lorsque le joueur place le bateau sur la grille

    // Constructeur
    public Navire(int id, TypeNavire type, int longueur)
    {
        this.setId(id);
        this.setType(type);
        this.setLongueur(longueur);
        this.position = new ArrayList<>();
        this.inFlotte = false;
    }

    // GETTERS
    public int getId() {
        return id;
    }
    public TypeNavire getType() {
        return type;
    }
    public int getLongueur() {
        return longueur;
    }
    public ArrayList<Coordonnee> getPosition() {
        return position;
    }
    public boolean isInFlotte() {
        return inFlotte;
    }

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

    public void setInFlotte(boolean inFlotte) {
        this.inFlotte = inFlotte;
    }
}
