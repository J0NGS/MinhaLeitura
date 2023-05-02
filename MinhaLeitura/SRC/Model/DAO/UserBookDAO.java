package SRC.Model.DAO;

import SRC.Model.DAO.Exceptions.DeleteException;
import SRC.Model.DAO.Exceptions.ReadException;
import SRC.Model.DAO.Exceptions.UpdateException;
import SRC.Model.VO.UserBook;
import Utils.BinaryPersisitence.BinaryUserBookHandler;
import Utils.ED.HashTable;
import Utils.ED.LinkedListDouble;

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
        return null;
    }

    public LinkedListDouble<UserBook> read(Long id) {
        HashTable<Long, UserBook> userBooks = this.handler.read();
        if(userBooks == null){
            throw new ReadException("Nenhum userBook encontrado, lista de userBook vazia ou inexistente");
        }else{
            LinkedListDouble<UserBook> userBookReturn = new LinkedListDouble<>();
            for(Long i = 1L; i < userBooks.size(); i++){
                userBookReturn.addLast(userBooks.get(id));
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
}
