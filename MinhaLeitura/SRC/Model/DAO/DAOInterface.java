package SRC.Model.DAO;

import Utils.ED.LinkedListDouble;

public interface DAOInterface <T>{
    public boolean create (T entity);
    public LinkedListDouble<T> read();
    public boolean update(Long id, T entity);
    public boolean delete(Long id);
}
