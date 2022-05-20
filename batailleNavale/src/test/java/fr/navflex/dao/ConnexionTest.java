package test.java.fr.navflex.sql;

public class ConnexionTest {
    private Connexion connexion;
    public void setUp(){
        this.connexion = new Connexion();
    }
    public void testConnexionTrue(){
        Connection connection = Connexion;
        assertNotNull(connection);
    }
}
