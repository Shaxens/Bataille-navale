package fr.navflex.modele.grille;

import java.util.Scanner;

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

	public boolean existeSurCetteGrille(int axeX, int axeY)
	{
		if (axeX < 0 || axeY < 0)
		{
			return false;
		}
		else return this.axeX >= axeX && this.axeY >= axeY;
	}

	public void placerPointSurGrille(int axeX, int axeY) throws IllegalArgumentException
	{
		if (!this.existeSurCetteGrille(axeX, axeY))
		{
			throw new IllegalArgumentException("Ce point n'existe pas sur cette grille.");
		}
		this.getGrille()[axeX][axeY] = 1;
	}
}
