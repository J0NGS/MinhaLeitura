package SRC.Model.DAO;

import SRC.Model.DAO.Exceptions.DeleteException;
import SRC.Model.DAO.Exceptions.ReadException;
import SRC.Model.DAO.Exceptions.UpdateException;
import SRC.Model.VO.Book;
import SRC.Model.VO.User;
import SRC.Model.VO.UserBook;
import Utils.BinaryPersisitence.BinaryUserBookHandler;
import Utils.ED.HashTable;
import Utils.ED.LinkedListDouble;

public class UserBookDAO implements DAOInterface<UserBook> {
    private BinaryUserBookHandler handler;
    private UserDAO userDao;
    private BookDAO bookDao;

    public UserBookDAO(){
        this.handler = new BinaryUserBookHandler("MinhaLeitura/Tests/Bin/UserBookDAO.bin");
        this.bookDao = new BookDAO();
        this.userDao = new UserDAO();
    }

    @Override
    public boolean create(UserBook entity) {
        // carregando lista de livros do usuário
        HashTable<Long, UserBook> userBooks = this.handler.read();
        if(userBooks == null){
            userBooks = new HashTable<>();
        }

        //Setando id
        Long id = (long) userBooks.size();
        id++;
        entity.setId(id);
        userBooks.put(entity.getBook(), entity);
        this.handler.save(userBooks);

        userBooks.clear();

        // Validando se o livro foi salvo no arquivo
        userBooks = this.handler.read();
        UserBook bookRead = userBooks.get(entity.getBook());
        if (bookRead.equals(entity)){
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public LinkedListDouble<UserBook> read() {
        HashTable<Long, UserBook> userBooks = this.handler.read();
        if(userBooks == null){
            throw new ReadException("Nenhum userBook encontrado, lista de userBook vazia ou inexistente");
        }else{
            LinkedListDouble<UserBook> userBookReturn = new LinkedListDouble<>();
            for(Long i = 1L; i < userBooks.size(); i++){
                userBookReturn.addLast(userBooks.get(i));
            }
            return userBookReturn;
        }
    }

    /**
     * Função que ler um UserBook específico no arquivo a partir do id
     * @param id id do UserBook
     * @return UserBook do id indicado
     */
    public UserBook readBook(Long id) {
        HashTable<Long, UserBook> books = this.handler.read();
        if (books == null) {
            throw new ReadException("Nenhum UserBook encontrado, lista de livros vazia ou inexistente");
        } else {
            UserBook bookReturn = books.get(id);
            if(bookReturn == null){
                throw new ReadException("Nenhum UserBook encontrado, lista de UserBook vazia ou inexistente");
            }
            return bookReturn;
        }
    }

    @Override
    public boolean update(Long id, UserBook entity) {
        HashTable<Long, UserBook> userBooks = this.handler.read();
        if(userBooks == null){
            throw new ReadException("Nenhum livro encontrado, lista de livros vazia ou inexistente");
        }else{
            UserBook bookRead = userBooks.get(id);
            if(bookRead == null){
                throw new UpdateException("Nenhum livro encontrado para essa chave");
            }else{
                entity.setId(id);
                userBooks.put(id, entity);
                handler.save(userBooks);
            }
            bookRead = userBooks.get(id);
            if(bookRead.equals(entity) && bookRead.getId() == id){
                return true;
            }else{
                return false;
            }
        }
    }

    @Override
    public boolean delete(Long id) {
        HashTable<Long, UserBook> userBooks = this.handler.read();
        if(userBooks.containsKey(id)){
            userBooks.remove(id);
            handler.save(userBooks);
            return true;
        }else{
            throw new DeleteException("Nenhum livro encontrado para essa chave");
        }
    }

    /**
     * Metódo que retorna userBook a partir do username do user propriétario
     * @param username username do user dono do userBook
     * @return Lista duplamente encadeada com todos os userBooks pertencentes ao usuário
     */
    public LinkedListDouble<UserBook> listByUser(String username){
        LinkedListDouble<UserBook> entitys = read();
        LinkedListDouble<UserBook> result = new LinkedListDouble<>();
        User user = userDao.listByUsername(username);
        for(int i = entitys.getSize(); i != 0; i--){
            if(entitys.peekFirst().getUserId() == user.getId()){
                result.addLast(entitys.peekFirst());
                entitys.removeFirst();
            }else{
                entitys.removeFirst();
            }
        }
        if(result == null){
            throw new ReadException("Nenhum userBook relacionado ao usuário encontrado");
        }
        return result;
    }

    /**
     * Metódo que retorna userBook a partir do id do livro
     * @param id id do livro buscado
     * @return Lista duplamente encadeada com todos os userBooks do livro buscado
     */
    public LinkedListDouble<UserBook> listByBook(Long id){
        LinkedListDouble<UserBook> entitys = read();
        LinkedListDouble<UserBook> result = new LinkedListDouble<>();
        Book book = bookDao.readBook(id);
        for(int i = entitys.getSize(); i != 0; i--){
            if(entitys.peekFirst().getUserId() == book.getId()){
                result.addLast(entitys.peekFirst());
                entitys.removeFirst();
            }else{
                entitys.removeFirst();
            }
        }
        if(result == null){
            throw new ReadException("Nenhum userBook relacionado ao livro encontrado");
        }
        return result;
    }
}
