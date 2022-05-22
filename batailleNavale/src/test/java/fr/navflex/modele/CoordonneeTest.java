package fr.navflex.modele;

import fr.navflex.modele.grille.Coordonnee;
import fr.navflex.modele.grille.Grille;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CoordonneeTest {

    private Grille grille;
    private Coordonnee coordonnee;

    @Before
    public void setUp() throws Exception {
        grille = new Grille(5,18);
    }
}
