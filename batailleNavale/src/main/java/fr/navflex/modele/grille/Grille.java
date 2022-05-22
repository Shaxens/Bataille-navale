package fr.navflex.modele.grille;

public class Grille {
	// ATTRIBUTS
	private int[][] grille;
	private  int axeX;
	private  int axeY;

	// CONSTRUCTEUR
	public Grille(int axeX, int axeY) throws Exception {
		this.setGrille(axeX, axeY);
		this.setAxeX(axeX);
		this.setAxeY(axeY);
	}

	// GETTER
	public int[][] getGrille() {
		return this.grille;
	}
	public int getAxeX() { return this.axeX; }
	public int getAxeY() { return this.axeY; }

	// SETTER
	public void setGrille(int axeX, int axeY) throws Exception {
		if (axeX * axeY >= 20) {
			this.grille = new int[axeX][axeY];
			this.remplirTableau(0);
		} else {
			throw new Exception("La grille doit être au minimum de 20 cases");
		}
	}

	public void setAxeX(int axeX)
	{
		this.axeX = axeX;
	}

	public void setAxeY(int axeY)
	{
		this.axeY = axeY;
	}

	// METHODES
	private void remplirTableau(int valeur)
	{
		for (int i = 0; i < this.getAxeX(); i++)
		{
			for (int j = 0; j < this.getAxeY(); j++) {
				this.getGrille()[i][j] = valeur;
			}
		}
	}

	public boolean existeSurCetteGrille(Coordonnee coordonnee)
	{
		if (!(this.axeX >= coordonnee.getPositionX() && this.axeY >= coordonnee.getPositionY()))
		{
			throw new IllegalArgumentException("Erreur : La Coordonnee " + coordonnee + " n'est pas sur cette grille.");
		}
		return true;
	}

	public int quelleValeurA(Coordonnee coordonnee) throws IllegalArgumentException
	{
		try
		{
			if (existeSurCetteGrille(coordonnee))
			{
				return this.getGrille()[coordonnee.getPositionX()][coordonnee.getPositionY()];
			}
		} catch (IllegalArgumentException iae)
		{
			throw new IllegalArgumentException(iae.getMessage());
		}
		return -1;
	}

	public boolean placerPointSurGrille(Coordonnee coordonnee, int valeur) throws IllegalArgumentException
	{
		try
		{
			if (existeSurCetteGrille(coordonnee))
			{
				this.getGrille()[coordonnee.getPositionX()][coordonnee.getPositionY()] = valeur;
				return true;
			}
		} catch (IllegalArgumentException iae)
		{
			throw new IllegalArgumentException(iae.getMessage());
		}
		return false;
	}

	public boolean estPlacable(Coordonnee coordonnee, int longueurNavire)
	{

		return true;
	}
}
