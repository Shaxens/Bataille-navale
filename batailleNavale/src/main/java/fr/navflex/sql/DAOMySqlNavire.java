  package main.java.fr.navflex.sql;

import java.util.ArrayList;

public interface DAOMySqlNavire<T>
{
    ArrayList<T> getAll();
    T getById(int id);
}
