package SRC.DAO;

import SRC.DAO.Exceptions.DeleteException;
import SRC.DAO.Exceptions.ReadException;
import SRC.DAO.Exceptions.UpdateException;
import SRC.Model.VO.UserBook;
import Utils.BinaryPersisitence.BinaryUserBookHandler;
import Utils.ED.HashTable;

public class UserBookDAO implements DAOInterface<UserBook> {
    private BinaryUserBookHandler handler;

    public UserBookDAO(){
        this.handler = new BinaryUserBookHandler("MinhaLeitura/Tests/Bin/UserBookDAO.bin");
    }

    @Override
    public boolean create(UserBook entity) {
        // carregando lista de livros do usuário
        HashTable<Long, UserBook> userBooks = this.handler.read();
        if(userBooks == null){
            userBooks = new HashTable<>();
        }

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
    public UserBook read(Long id) {
        HashTable<Long, UserBook> userBooks = this.handler.read();
        if(userBooks == null){
            throw new ReadException("Nenhum livro encontrado, lista de livros vazia ou inexistente");
        }
        UserBook bookReturn = userBooks.get(id);
        if(bookReturn == null){
            throw new ReadException("Livro não encontrado");
        }
        return bookReturn;
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
                userBooks.put(id, entity);
                handler.save(userBooks);
            }
            bookRead = userBooks.get(id);
            if(bookRead.equals(entity)){
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
}
