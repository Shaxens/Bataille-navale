package fr.navflex.modele.joueur;

import fr.navflex.modele.grille.Coordonnee;
import fr.navflex.modele.grille.Grille;
import fr.navflex.modele.navire.Flotte;
import fr.navflex.modele.navire.Navire;

import java.util.ArrayList;

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
        try
        {
            this.getFlotte().ajoutPossibleById(id);
            Navire navire = new Navire(id);
            System.out.println("Veuillez saisir les coordonnee du navire " + navire.getId() + " : " + navire.getType());
            ArrayList<Coordonnee> listCoordonnee = new ArrayList<>();
            for (int i = 0; i < navire.getLongueur(); i++)
            {
                listCoordonnee.add(new Coordonnee().saisirCoordonnee());
            }
            navire.setPosition(listCoordonnee);
            navire.setPointsVie();
            navire.setInGrille(true);
            this.getFlotte().addNavire(navire);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return true;
    }

    @Override
    public String toString() {
        System.out.println("Voici donc votre nom pour cette partie : ");
        System.out.println("Le nom du joueur " + this.getId() + " est " + this.getNom());
        return "Le nom du joueur "+ this.getId() + " est " + this.getNom();
    }
}
