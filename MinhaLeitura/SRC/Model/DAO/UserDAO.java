package SRC.Model.DAO;

import SRC.Model.DAO.Exceptions.DeleteException;
import SRC.Model.DAO.Exceptions.ReadException;
import SRC.Model.DAO.Exceptions.UpdateException;
import SRC.Model.VO.User;
import Utils.BinaryPersisitence.BinaryUserHandler;
import Utils.ED.HashTable;
import Utils.ED.LinkedListDouble;

public class UserDAO implements DAOInterface<User>{
    private BinaryUserHandler handler;


    public UserDAO(){
        this.handler = new BinaryUserHandler("MinhaLeitura/Tests/Bin/UserDAO.bin");
    }

    @Override
    public boolean create(User entity) {
        // carregando lista de usuários
        HashTable<Long, User> users = this.handler.read();                  // Inicializa o elemento
        if(users == null){                                                  // Se a hashtable carregada não tiver nenhum usuário
            users = new HashTable<>();                                      // Inicializa o elemento
        }

        Long id = (long) users.size();
        id++;
        entity.setId(id);
        users.put(entity.getId(), entity);
        this.handler.save(users);

        users.clear();

        // Validando se o usuário foi salvo no arquivo
        users = this.handler.read();
        User userRead = users.get(entity.getId());
        if (userRead.equals(entity)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public LinkedListDouble<User> read() {
        HashTable<Long, User> users = this.handler.read();
        if (users == null) {
            throw new ReadException("Nenhum usuário encontrado, lista de usuários vazia ou inexistente");
        } else {
            LinkedListDouble<User> userReturn = new LinkedListDouble<>();
            for (Long i = 0L; i < users.size(); i++){
                userReturn.addLast(users.get(i));
            }
            return userReturn;
        }
    }

    public User readUser(Long id) {
        HashTable<Long, User> users = this.handler.read();
        if (users == null) {
            throw new ReadException("Nenhum user encontrado, lista de users vazia ou inexistente");
        } else {
            User userReturn = users.get(id);
            if(userReturn == null){
                throw new ReadException("Nenhum livro encontrado, lista de livros vazia ou inexistente");
            }
            return userReturn;
        }
    }


    @Override
    public boolean update(Long id, User entity) {
        HashTable<Long, User> users = this.handler.read();                  // Inicializa o elemento
        if(users == null){
            throw new ReadException("User não encontrado, lista de user vazia ou inexistente");
        }else{
            User userRead = users.get(id);
            if(userRead == null){
                throw new UpdateException("Nenhum usuário encontrado para essa chave");
            }else{
                users.put(id, entity);
                handler.save(users);
            }
            userRead = users.get(id);
            if(userRead.equals(entity) && userRead.getId() == id){
                return true;
            }else{
                return false;
            }
        }

    }

    @Override
    public boolean delete(Long id) {
        HashTable<Long, User> users = this.handler.read();                  // Inicializa o elemento
        if(users.containsKey(id)){
            users.remove(id);
            handler.save(users);
            return true;
        } else{
            throw new DeleteException("User não encontrado");
        }
    }
    
}
