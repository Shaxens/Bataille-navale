package main.java.fr.navflex.gameplay.grille;

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
	public void saisieTailleGrille() {
		System.out.print("Entrez le nombre de lignes : ");
		Scanner scanner = new Scanner(System.in);
		if (scanner.hasNextInt()) {
			System.out.println("Nombre de ligne : " + scanner);
		} else {
			System.out.println("La saisie doit être un entier");
		}
		System.out.print("Entrez le nombre de colonnes : ");
		Scanner scannerC = new Scanner(System.in);
		if (scanner.hasNextInt()) {
			System.out.println("Nombre de colonne : " + scannerC);
		} else {
			System.out.println("La saisie doit être un entier");
		}
		// this.setGrille(scanner, scannerC); // A voir
		// }
	}
}
