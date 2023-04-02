package SRC.DAO;

public interface DAOInterface <T>{
    public boolean create (T entity);
    public T read(Long id);
    public boolean update(Long id, T entity);
    public boolean delete(Long id);
}
