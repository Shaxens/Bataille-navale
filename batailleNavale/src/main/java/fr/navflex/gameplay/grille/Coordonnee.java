package main.java.fr.navflex.gameplay.grille;

import main.java.fr.navflex.gameplay.navire.Navire;

import java.util.ArrayList;
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
    public Coordonnee saisirCoordonnee()
    {
        Coordonnee coordonnee = new Coordonnee();

        Scanner scan = new Scanner(System.in);
        int positionX = 0;
        int positionY = 0;

        System.out.println("Entrez la position X : ");
        try {
            positionX = scan.nextInt();
        } catch (Exception e)
        {
            System.out.println("Erreur : " + e);
        }

        System.out.println("Entrez la position Y : ");
        try {
            positionY = scan.nextInt();
        } catch (Exception e)
        {
            System.out.println("Erreur : " + e);
        }

        coordonnee.setPositionX(positionX);
        coordonnee.setPositionY(positionY);

        return coordonnee;
    }

    public boolean estValideParTypeNavire(Navire navire) throws Exception // En cours de dev
    {
        if (navire.getPosition().size() > 0)
        {
            for (int i = 1; i < navire.getLongueur(); i++)
            {
                Coordonnee coordonneePrecedente = navire.getPosition().get(i-1);
                int xSuivant = this.getPositionX();
                int ySuivant = this.getPositionY();
                int xPrecedent = coordonneePrecedente.getPositionX();
                int yPrecedent = coordonneePrecedente.getPositionY();

                if (xSuivant == xPrecedent && ySuivant == yPrecedent)
                {
                    throw new Exception("Erreur : Un des points du bateau est deja en coordonnee : " + this);
                }
                if (xSuivant - xPrecedent > 1)
                {
                    throw new Exception("Erreur : La ");
                }
            }
        }
        return true;
    }



    @Override
    public String toString() {
        return "[ " + positionX + ", " + positionY + "]";
    }
}
