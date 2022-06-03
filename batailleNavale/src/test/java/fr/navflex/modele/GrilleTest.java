package fr.navflex.modele;

import fr.navflex.modele.grille.Coordonnee;
import fr.navflex.modele.grille.Grille;
import fr.navflex.modele.navire.Navire;
import fr.navflex.modele.navire.TypeNavire;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class GrilleTest {

	private Grille grille;

	@Before
	public void setUp() throws Exception {
		grille = new Grille(10, 10);
	}

	@Test(expected = Exception.class)
	public void testsetGrilleIsNotValid() throws Exception {
		try {
			grille.setGrille(0, 0);
		} catch (Exception e) {
			Assert.assertEquals("La grille doit être au minimum de 20 cases", e.getMessage());
			throw e;
		}
	}
	@Test
	public void testExisteSurCetteGrille()
	{
		Coordonnee coordonnee1 = new Coordonnee(1,1);
		Coordonnee coordonnee2 = new Coordonnee(0,7);
		Assert.assertTrue(grille.existeSurCetteGrille(coordonnee1));
		Assert.assertTrue(grille.existeSurCetteGrille(coordonnee2));
	}

	@Test
	public void testSetOnCoordonnee()
	{
		Coordonnee coordonnee1 = new Coordonnee(1,1);
		grille.setOnCoordonnee(coordonnee1, 1);
		int test = grille.getOnCoordonnee(coordonnee1);
		Assert.assertEquals(1, test);
	}
	@Test
	public void testGetOnCoordonnee()
	{
		Coordonnee coordonnee1 = new Coordonnee(1,1);
		Coordonnee coordonnee2 = new Coordonnee(2,2);
		grille.setOnCoordonnee(coordonnee1, 1);
		int test = grille.getOnCoordonnee(coordonnee1);
		Assert.assertEquals(1, test);
		int test2 = grille.getOnCoordonnee(coordonnee2);
		Assert.assertEquals(0, test2);
	}

	@Test(expected = Exception.class)
	public void testEstPlacable()
	{
		Coordonnee coordonnee1 = new Coordonnee(1,1);
		Coordonnee coordonnee2 = new Coordonnee(2,2);
		grille.setOnCoordonnee(coordonnee1, 1);
		Assert.assertTrue(grille.estPlacable(coordonnee2));
		try {
			grille.estPlacable(coordonnee1);
		} catch (Exception e) {
			Assert.assertEquals("Erreur : Un point est deja en place en coordonnee " + coordonnee1 + ".", e.getMessage());
			throw e;
		}
	}

	@Test
	public void testGetListePositionPossible()
	{
		Coordonnee coordonnee1 = new Coordonnee(5,5);
		Coordonnee coordonnee2 = new Coordonnee(9,9);
		Navire navire1 = new Navire(1, TypeNavire.PorteAvions, 5);
		ArrayList<ArrayList<Coordonnee>> listePositionNavire1 = grille.getListePositionPossible(coordonnee1, navire1);
		ArrayList<ArrayList<Coordonnee>> listePositionNavire2 = grille.getListePositionPossible(coordonnee2, navire1);
		Assert.assertEquals(4, listePositionNavire1.size());
		Assert.assertEquals(2, listePositionNavire2.size());
	}
}
