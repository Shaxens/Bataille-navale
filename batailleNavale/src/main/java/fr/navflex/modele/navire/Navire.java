package fr.navflex.modele.navire;

import fr.navflex.modele.grille.Coordonnee;
import fr.navflex.dao.DAONavire;

import java.util.ArrayList;

public class Navire
{
    // Attributs
    private int id; // id du bateau issu de la bdd
    private TypeNavire type; // type du navire qui définira sa longueur (lien fait dans la bdd)
    private int longueur; // La longueur correspond au nombre de point du bateau à toucher
    private ArrayList<Coordonnee> position; // Un array de Coordonnée (une pour chaque point du bateau)
    private boolean inGrille; // False par default, passera à true lorsque le joueur place le bateau sur la grille
    private int pointsVie;

    // Constructeur
    public Navire(int id, TypeNavire type, int longueur)
    {
        this.setId(id);
        this.setType(type);
        this.setLongueur(longueur);
        this.position = new ArrayList<>();
        this.inGrille = false;
        this.setPointsVie();
    }

    public Navire(int id)
    {
        ArrayList<Navire> allNavire = DAONavire.getInstance().getAll();
        for (Navire navire : allNavire)
        {
            if (id == navire.getId())
            {
                this.setId(id);
                this.setType(navire.getType());
                this.setLongueur(navire.getLongueur());
                this.position = new ArrayList<>();
                this.inGrille = false;
                this.setPointsVie();
            }
        }
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
    public boolean getInGrille() {
        return this.inGrille;
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

    public void setInGrille(boolean inGrille) {
        this.inGrille = inGrille;
    }

    public void setPointsVie() {this.pointsVie = this.getPosition().size();}

    // METHODES






    @Override
    public String toString() {
        if (this.inGrille)
        {
            return "Navire " + id + " : " + type + " ptsVie : " + pointsVie + " de longueur " + longueur + " en position " + position;
        }
        else
        {
            return "Navire " + id + " : " + type + " de longueur " + longueur;
        }
    }
}
