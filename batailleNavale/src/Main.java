import gameplay.*;
import sql.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Navire> flotte = MySqlNavire.getInstance().getAll();
        for (Navire navire : flotte)
        {
            System.out.println("id : " + navire.getId());
            System.out.println("type : " + navire.getType());
            System.out.println("longueur : " + navire.getLongueur());
        }
    }
}
