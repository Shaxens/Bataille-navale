package sql;

import java.util.ArrayList;

public interface DAO<T>
{
    abstract ArrayList<T> getAll();
}
