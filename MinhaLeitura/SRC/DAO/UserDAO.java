package SRC.DAO;

import SRC.DAO.Exceptions.DeleteException;
import SRC.DAO.Exceptions.ReadException;
import SRC.DAO.Exceptions.UpdateException;
import SRC.Model.VO.User;
import Utils.BinaryPersisitence.BinaryUserHandler;
import Utils.ED.HashTable;

public class UserDAO implements DAOInterface<User>{
    private BinaryUserHandler handler;


    public UserDAO(){
        this.handler = new BinaryUserHandler("MinhaLeitura/Tests/Bin/User.bin");
    }

    @Override
    public boolean create(User entity) {
        // carregando lista de usuários
        HashTable<Long, User> users = this.handler.read();                  // Inicializa o elemento
        if(users == null){                                                  // Se a hashtable carregada não tiver nenhum usuário
            users = new HashTable<>();                                      // Inicializa o elemento
        }

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
    public User read(Long id) {
        HashTable<Long, User> users = this.handler.read();                  // Inicializa o elemento
        if(users == null){
            throw new ReadException("User não encontrado, lista de user vazia ou inexistente");
        }else{
            User userReturn = users.get(id);
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
            }
            userRead = users.get(id);
            if(userRead.equals(entity)){
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
            return true;
        } else{
            throw new DeleteException("User não encontrado");
        }
    }
    
}
