package fr.navflex.modele;

import fr.navflex.modele.grille.Grille;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GrilleTest {

	private Grille grille;

	@Before
	public void setUp() throws Exception {
		grille = new Grille(1, 20);
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
	public void testsetGrilleIsValid() throws Exception {
		grille.setGrille(3, 8);
		Assert.assertNotNull(grille.getGrille());
	}

}
