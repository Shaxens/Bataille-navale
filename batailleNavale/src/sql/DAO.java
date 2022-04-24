package sql;

import java.util.ArrayList;

public interface DAO<T>
{
    ArrayList<T> getAll();
    T getById(int id);
}
