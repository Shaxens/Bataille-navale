package tests.fr.navflex.gameplay.navire;


import fr.navflex.gameplay.navire.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FlotteTest {

    // Attributs
    private Navire navire1;
    private Navire navire2;
    private Flotte flotte;

    // Setup des tests
    @Before
    public void setUp() {
        navire1 = new Navire(2, TypeNavire.Torpilleur, 3);
        flotte = new Flotte(1);
    }

    // Tests



}
