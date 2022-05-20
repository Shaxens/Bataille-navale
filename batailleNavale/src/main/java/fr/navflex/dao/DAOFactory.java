  package fr.navflex.dao;

import java.util.ArrayList;

public interface DAOFactory<T>
{
    ArrayList<T> getAll();
    T getById(int id);
}
