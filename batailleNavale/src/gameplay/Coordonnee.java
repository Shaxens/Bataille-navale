package gameplay;

public class Coordonnee
{
    // ATTRIBUTS
    private char positionX;
    private int positionY;

    // CONSTRUCTEUR
    public Coordonnee(char positionX, int postionY)
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
    public void setPositionX(char positionX) {
        this.positionX = positionX;
    }
    public void setPositionY(int positionY) { this.positionY = positionY; }
}
