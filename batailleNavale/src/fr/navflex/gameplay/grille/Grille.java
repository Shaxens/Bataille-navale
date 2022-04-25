package fr.navflex.gameplay.grille;

public class Grille
{
    // ATTRIBUTS
    private int[][] grille;

    // CONSTRUCTEUR
    public Grille(int ligne, int colonne)
    {
        this.setGrille(ligne,colonne);
    }

    // GETTER
    public int[][] getGrille() {
        return grille;
    }

    // SETTER
    public void setGrille(int ligne, int colonne)
    {
        this.grille = new int[ligne][colonne];
    }

}
