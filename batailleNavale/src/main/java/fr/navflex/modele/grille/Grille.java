package fr.navflex.modele.grille;

import fr.navflex.modele.navire.Navire;

import java.util.ArrayList;

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
			this.remplirTableau();
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
	private void remplirTableau()
	{
		for (int i = 0; i < this.getAxeX(); i++)
		{
			for (int j = 0; j < this.getAxeY(); j++) {
				this.getGrille()[i][j] = 0;
			}
		}
	}

	private boolean existeSurCetteGrille(Coordonnee coordonnee)
	{
		if (!(this.axeX >= coordonnee.getPositionX() && this.axeY >= coordonnee.getPositionY()))
		{
			throw new IllegalArgumentException("Erreur : La Coordonnee " + coordonnee + " n'est pas sur cette grille.");
		}
		return true;
	}

	public int getOnCoordonnee(Coordonnee coordonnee) throws IllegalArgumentException
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

	public boolean setOnCoordonnee(Coordonnee coordonnee, int valeur) throws IllegalArgumentException
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

	public boolean estPlacable(Coordonnee coordonnee)
	{
		try
		{
			int valeur = this.getOnCoordonnee(coordonnee);
			if (valeur == 0)
			{
				return true;
			}
			throw new IllegalArgumentException("Erreur : Un point est deja en place en coordonnee " + coordonnee + ".");

		} catch (IllegalArgumentException iae)
		{
			throw new IllegalArgumentException(iae.getMessage());
		}
	}

	private boolean placementVersLaDroitePossible(Coordonnee coordonnee, int longueur)
	{
		int x = coordonnee.getPositionX();
		int y = coordonnee.getPositionY();
		try {
			for (int i = 0; i < longueur; i++) {
				if (estPlacable(coordonnee))
				{
					y += 1;
					coordonnee = new Coordonnee(x, y);
				}
			}
			return true;
		}catch (IllegalArgumentException | ArrayIndexOutOfBoundsException iae) {
			return false;
		}
	}

	private boolean placementVersLaGauchePossible(Coordonnee coordonnee, int longueur)
	{
		int x = coordonnee.getPositionX();
		int y = coordonnee.getPositionY();
		if (y + 1 < longueur)
		{
			return false;
		}
		try {
			for (int i = 0; i < longueur; i++) {
				if (estPlacable(coordonnee))
				{
					y -= 1;
					if (y >= 0)
					{
						coordonnee = new Coordonnee(x, y);
					}
				}
			}
			return true;
		}catch (IllegalArgumentException | ArrayIndexOutOfBoundsException iae) {
			return false;
		}

	}

	private boolean placementVersLeHautPossible(Coordonnee coordonnee, int longueur)
	{
		int x = coordonnee.getPositionX();
		int y = coordonnee.getPositionY();
		if (x + 1 < longueur)
		{
			return false;
		}
		try {
			for (int i = 0; i < longueur; i++) {
				if (estPlacable(coordonnee))
				{
					x -= 1;
					if(x >= 0)
					{
						coordonnee = new Coordonnee(x, y);
					}
				}
			}
			return true;
		}catch (IllegalArgumentException | ArrayIndexOutOfBoundsException iae) {
			return false;
		}
	}

	private boolean placementVersLeBasPossible(Coordonnee coordonnee, int longueur)
	{
		int x = coordonnee.getPositionX();
		int y = coordonnee.getPositionY();
		try {
			for (int i = 0; i < longueur; i++) {
				if (estPlacable(coordonnee))
				{
					x += 1;
					coordonnee = new Coordonnee(x, y);
				}
			}
			return true;
		}catch (IllegalArgumentException | ArrayIndexOutOfBoundsException iae) {
			return false;
		}
	}

	private ArrayList<Coordonnee> creerListeCoordonneeVersLaDroite(Coordonnee coordonnee, int longueur)
	{
		int x = coordonnee.getPositionX();
		int y = coordonnee.getPositionY();
		ArrayList<Coordonnee> liste = new ArrayList<>();
		for (int i = 0; i < longueur; i++) {
			{
				liste.add(coordonnee);
				y += 1;
				coordonnee = new Coordonnee(x, y);
			}
		}
		return liste;
	}

	private ArrayList<Coordonnee> creerListeCoordonneeVersLaGauche(Coordonnee coordonnee, int longueur)
	{
		int x = coordonnee.getPositionX();
		int y = coordonnee.getPositionY();
		ArrayList<Coordonnee> liste = new ArrayList<>();
		for (int i = 0; i < longueur; i++) {
			{
				liste.add(coordonnee);
				y -= 1;
				if (y >= 0)
				{
					coordonnee = new Coordonnee(x, y);
				}
			}
		}
		return liste;
	}

	private ArrayList<Coordonnee> creerListeCoordonneeVersLeHaut(Coordonnee coordonnee, int longueur)
	{
		int x = coordonnee.getPositionX();
		int y = coordonnee.getPositionY();
		ArrayList<Coordonnee> liste = new ArrayList<>();
		for (int i = 0; i < longueur; i++) {
			{
				liste.add(coordonnee);
				x -= 1;
				if (x >= 0)
				{
					coordonnee = new Coordonnee(x, y);
				}
			}
		}
		return liste;
	}

	private ArrayList<Coordonnee> creerListeCoordonneeVersLeBas(Coordonnee coordonnee, int longueur)
	{
		int x = coordonnee.getPositionX();
		int y = coordonnee.getPositionY();
		ArrayList<Coordonnee> liste = new ArrayList<>();
		for (int i = 0; i < longueur; i++) {
			{
				liste.add(coordonnee);
				x += 1;
				coordonnee = new Coordonnee(x, y);
			}
		}
		return liste;
	}

	public ArrayList<ArrayList<Coordonnee>> getListePositionPossible(Coordonnee coordonnee, Navire navire)
	{
		ArrayList<ArrayList<Coordonnee>> listePositionPossible = new ArrayList<>();
		int longueur = navire.getLongueur();

		if (this.placementVersLaDroitePossible(coordonnee, longueur))
		{
			listePositionPossible.add(this.creerListeCoordonneeVersLaDroite(coordonnee, longueur));
		}
		if (this.placementVersLaGauchePossible(coordonnee, longueur))
		{
			listePositionPossible.add(this.creerListeCoordonneeVersLaGauche(coordonnee,longueur));
		}
		if (this.placementVersLeHautPossible(coordonnee, longueur))
		{
			listePositionPossible.add(this.creerListeCoordonneeVersLeHaut(coordonnee,longueur));
		}
		if (this.placementVersLeBasPossible(coordonnee, longueur))
		{
			listePositionPossible.add(this.creerListeCoordonneeVersLeBas(coordonnee,longueur));
		}

		return listePositionPossible;
	}

	public void placerNavireSurGrille(ArrayList<Coordonnee> positionNavire, Navire navire) {
		for (Coordonnee pointsAPlacer : positionNavire) {
			this.setOnCoordonnee(pointsAPlacer, navire.getId());
		}
		navire.setPosition(positionNavire);
		navire.setInGrille(true);
	}

	public int faireFeuEn(Coordonnee coordonnee) throws Exception {
		int valeurCase;
		try
		{
			valeurCase = getOnCoordonnee(coordonnee);

		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
		if (valeurCase != 0)
		{
			setOnCoordonnee(coordonnee, 0);
		}
		return valeurCase;
	}
}
