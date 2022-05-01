package fr.navflex.gameplay.grille;

import fr.navflex.joueur.Joueur;

import java.util.Scanner;

public class Coordonnee
{
    // ATTRIBUTS
    private int positionX;
    private int positionY;

    // CONSTRUCTEUR
    public  Coordonnee()
    {

    }

    public Coordonnee(int positionX, int postionY)
    {
        this.setPositionX(positionX);
        this.setPositionY(postionY);
    }

    // GETTERS
    public int getPositionX() {
        return this.positionX;
    }
    public int getPositionY() {
        return this.positionY;
    }

    // SETTERS
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }
    public void setPositionY(int positionY) { this.positionY = positionY; }

    // METHODES
    public boolean saisirCoordonnee()
    {
        Scanner scan = new Scanner(System.in);
        int positionX = 0;
        int positionY = 0;

        System.out.println("Entrez la position X : ");
        try {
            positionX = scan.nextInt();
        } catch (Exception e)
        {
            System.out.println("Erreur : " + e);
            return false;
        }

        System.out.println("Entrez la position Y : ");
        try {
            positionY = scan.nextInt();
        } catch (Exception e)
        {
            System.out.println("Erreur : " + e);
            return false;
        }

        this.setPositionX(positionX);
        this.setPositionY(positionY);
        return true;
    }


    @Override
    public String toString() {
        return "[ " + positionX + ", " + positionY + "]";
    }
}
