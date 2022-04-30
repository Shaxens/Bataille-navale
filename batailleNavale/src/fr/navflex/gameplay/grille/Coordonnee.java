package fr.navflex.gameplay.grille;

public class Coordonnee
{
    // ATTRIBUTS
    private int positionX;
    private int positionY;

    // CONSTRUCTEUR
    public Coordonnee(int positionX, int postionY)
    {
        this.setPositionX(positionX);
        this.setPositionY(postionY);
    }

    // GETTERS
    public int getPositionX() {
        return positionX;
    }
    public int getPositionY() {
        return positionY;
    }

    // SETTERS
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }
    public void setPositionY(int positionY) { this.positionY = positionY; }
}
