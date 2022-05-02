package tests.fr.navflex.gameplay.navire;


import fr.navflex.gameplay.navire.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FlotteTest {

    // Attribut
    private Flotte flotte;

    private Navire porteAvions;
    private Navire croiseur;
    private Navire contreTorpilleur1;
    private Navire contreTorpilleur2;
    private Navire torpilleur;

    // Setup des tests
    @Before
    public void setUp() {
        this.flotte = new Flotte(1);

        this.porteAvions = new Navire(1);
        this.croiseur = new Navire(2);
        this.contreTorpilleur1 = new Navire(3);
        this.contreTorpilleur2 = new Navire(4);
        this.torpilleur = new Navire(5);
    }

    // Tests
    @Test(expected = Exception.class)
    public void testAjoutPossibleById() throws Exception
    {

        // On test la methodes lorsque la flotte est vide avec l'id = 1, le retour doit être true
        Assert.assertTrue(flotte.ajoutPossibleById(1));

        // On ajoute le navire d'id 1
        flotte.addNavire(porteAvions);
        try {
            flotte.ajoutPossibleById(1);
        } catch (Exception e) {
            // On test alors la methode qui doit lever une exception car ce navire est déjà présent dans la flotte
            Assert.assertEquals("Erreur : le " + porteAvions.getType() + " d'id(" + porteAvions.getId() + ") fait deja parti de la flotte " + flotte.getId(), e.getMessage());
            throw e;
        }

        // On test maintenant la validité de l'id qui doit être impérativement entre 1 et 5
        try {
            flotte.ajoutPossibleById(0);
        }
        catch (Exception e)
        {
            Assert.assertEquals("Erreur : l'id saisie est invalide", e.getMessage());
            throw e;
        }

        try {
            flotte.ajoutPossibleById(6);
        }
        catch (Exception e)
        {
            Assert.assertEquals("Erreur : l'id saisie est invalide", e.getMessage());
            throw e;
        }
    }

    @Test
    public void testAddNavire()
    {
        // On doit pouvoir ajouter un navire tant que son id est valide (entre 1 et 5) et il ne doit pas deja etre présent
        // L'issue de ces 2 tests doit etre true :
        Assert.assertTrue(flotte.addNavire(porteAvions));
        Assert.assertTrue((flotte.addNavire(torpilleur)));

        // On essaye maintenant de les ajouter à nouveau dans la même flotte, l'issue doit être false
        Assert.assertFalse(flotte.addNavire(porteAvions));
        Assert.assertFalse(flotte.addNavire(torpilleur));

        // On test maintenant avec un navire dont l'id n'est pas bon
        Navire navireMauvaisId = new Navire(6,TypeNavire.Torpilleur,5);
        Assert.assertFalse(flotte.addNavire(navireMauvaisId));
    }

    @Test(expected = Exception.class)
    public void testGetNavireById() throws Exception
    {
        // Si la flotte est vide :
        try
        {
            flotte.getNavirebyId(1);
        }
        catch (Exception e)
        {
            Assert.assertEquals("Erreur : la flotte " + flotte.getId() + " est vide.", e.getMessage());
            throw e;
        }

        // Si la flotte est vide et que l'id est incorrect
        try
        {
            flotte.getNavirebyId(0);
        }
        catch (Exception e)
        {
            Assert.assertEquals("Erreur : la flotte " + flotte.getId() + " est vide et l'id(" + 0 + ") n'existe pas.", e.getMessage());
            throw e;
        }

        // On ajoute 1 navire à la flotte
        flotte.addNavire(porteAvions);
        // On doit pouvoir récupérer ce navire dans la flotte
        Navire navireTest = flotte.getNavirebyId(1);
        Assert.assertEquals(navireTest.getId(),porteAvions.getId());

        // Si on recherche un navire qui n'est pas présent dans la flotte mais que celle ci n'est pas vide
        try
        {
            flotte.getNavirebyId(2);
        }
        catch (Exception e)
        {
            Assert.assertEquals("Erreur : le navire " + 2 + "n est pas dans la flotte " + flotte.getId(), e.getMessage());
            throw e;
        }

        // Si la flotte n'est pas vide mais que l'id est invalide
        try
        {
            flotte.getNavirebyId(6);
        }
        catch (Exception e)
        {
            Assert.assertEquals("Erreur : l'id(" + 6 + ") n'existe pas.", e.getMessage());
            throw e;
        }
    }
}
