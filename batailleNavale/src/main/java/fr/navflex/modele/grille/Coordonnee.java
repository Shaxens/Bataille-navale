package fr.navflex.modele.grille;

import fr.navflex.modele.navire.Navire;

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
        if (positionX < 0)
        {
           throw new IllegalArgumentException("Erreur : X est inferieur a 0.");
        }
        this.positionX = positionX;
    }
    public void setPositionY(int positionY) {
        if (positionY < 0)
        {
            throw new IllegalArgumentException("Erreur : Y est inferieur a 0.");
        }
        this.positionY = positionY;
    }

    // METHODES

    @Override
    public String toString() {
        return "[" + positionX + "," + positionY + "]";
    }
}
