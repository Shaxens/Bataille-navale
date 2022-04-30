package fr.navflex.gameplay.grille;

import java.util.Scanner;

public class Grille {
	// ATTRIBUTS
	private int[][] grille;

	// CONSTRUCTEUR
	public Grille(int ligne, int colonne) throws Exception {
		this.setGrille(ligne, colonne);
	}

	// GETTER
	public int[][] getGrille() {
		return grille;
	}

	// SETTER
	public void setGrille(int ligne, int colonne) throws Exception {
		if (ligne * colonne >= 20) {
			this.grille = new int[ligne][colonne];
		} else {
			throw new Exception("La grille doit être au minimum de 20 cases");
		}
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
