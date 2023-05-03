/**
 * Classe para representar a camada de persistencia de dados em binário para user
 * @author João Gonçalo
 */
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

    // Construtor
    public UserDAO(){
        this.handler = new BinaryUserHandler("MinhaLeitura/Tests/Bin/UserDAO.bin");
    }

    /**
     * Persiste um usuário em um arquivo binário a partir de um usuário fornecido
     */
    @Override
    public boolean create(User entity) {
        
        // carregando lista de usuários
        HashTable<Long, User> users = this.handler.read();                  // Inicializa o elemento
        if(users == null){                                                  // Se a hashtable carregada não tiver nenhum usuário
            users = new HashTable<>();                                      // Inicializa o elemento
        }

        //Setando o id
        Long id = (long) users.size();                                      // verifica o tamanho da lista para saber qual o próximo id
        id++;                                                               // define novo id com incremento
        entity.setId(id);                                                   // chama função setar o id
        users.put(entity.getId(), entity);                                  // Inserindo o usuário na hashtable
        this.handler.save(users);                                           // Persistindo hashtable

        users.clear();                                                      // Limpa a hashtable

        // Validando se o usuário foi salvo no arquivo
        users = this.handler.read();                                        // Lendo arquivo persistido
        User userRead = users.get(entity.getId());                          // recebendo user a partir do id
        if (userRead.equals(entity)){                                       // Comparando user com o paramentro passado
            return true;
        }else{
            return false;
        }
    }


    /**
     * Metodo que retorna todos os usuários em uma lista encadeada
     */
    @Override
    public LinkedListDouble<User> read() {
        HashTable<Long, User> users = this.handler.read();
        if (users == null) {
            throw new ReadException("Nenhum usuário encontrado, lista de usuários vazia ou inexistente");
        } else {
            LinkedListDouble<User> userReturn = new LinkedListDouble<>();
            for (Long i = 1L; i < users.size(); i++){
                if(users.get(i) != null){
                userReturn.addLast(users.get(i));
                }
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
                entity.setId(id);
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

    /**
     * Função para listar pelo username
     */

     public User listByUsername(String username){
        LinkedListDouble<User> users = read();
        User result = new User();
        for(int i = users.getSize() ; i != 0; i--){
            if(users.peekFirst().getUsername().equals(username)){
                result = users.peekFirst();
            }else{
                users.removeFirst();
            }
        }
        if(result == null){
            throw new ReadException("Usuário não encontrado");
        }
        return result;
    }

    /**
     * Função para listar pelo email
     */

     public User listByEmail(String email){
        LinkedListDouble<User> users = read();
        User result = new User();
        for(int i = users.getSize() ; i != 0; i--){
            if(users.peekFirst().getEmail().equals(email)){
                result = users.peekFirst();
            }else{
                users.removeFirst();
            }
        }
        return result;
    }


    
}
