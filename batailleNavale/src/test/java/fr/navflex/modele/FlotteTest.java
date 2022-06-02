package fr.navflex.modele;


import fr.navflex.modele.navire.Flotte;
import fr.navflex.modele.navire.Navire;
import fr.navflex.modele.navire.TypeNavire;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FlotteTest {

    // Attribut
    private final Flotte flotte = new Flotte(1);


    // Setup des tests
    @Before
    public void setUp() {

    }

    @Test
    public void testGetNavireById()
    {
        Navire navire1 = flotte.getNavireById(1);
        Navire navire2 = flotte.getNavireById(3);
        Navire navire3 = flotte.getNavireById(5);
        Assert.assertEquals(5, navire1.getLongueur());
        Assert.assertEquals(TypeNavire.ContreTorpilleur, navire2.getType());
        Assert.assertEquals(0, navire3.getPointsVie());
    }

    @Test
    public void testGetListeNavireAPlacer()
    {
        Assert.assertEquals(5, flotte.getListeNavireAPlacer().size());
    }

    @Test
    public void testGetListeNavireEnMere()
    {
        Assert.assertEquals(0, flotte.getListeNavireEnMer().size());
    }
}
