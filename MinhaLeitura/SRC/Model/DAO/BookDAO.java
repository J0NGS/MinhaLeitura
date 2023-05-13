/**
 * Classe para representar a camda de persistencia de dados em binário para book
 * @author João Gonçalo
 */
package SRC.Model.DAO;

import javax.lang.model.util.ElementScanner14;

import SRC.Model.DAO.Exceptions.DeleteException;
import SRC.Model.DAO.Exceptions.ReadException;
import SRC.Model.DAO.Exceptions.UpdateException;
import SRC.Model.VO.Book;
import Utils.BinaryPersisitence.BinaryBookHandler;
import Utils.ED.HashTable;
import Utils.ED.LinkedListDouble;


public class BookDAO implements DAOInterface<Book>{

    private BinaryBookHandler handler;

    // Construtor do manipulador de binário
    public BookDAO() {
        this.handler = new BinaryBookHandler("MinhaLeitura/Tests/Bin/BookDAO.bin");
    }


    /**
     * Persiste o livro em arquivo binário a partir do livro fornecido
     * @param entity Livro a ser persistido
     */
    @Override
    public boolean create(Book entity) {
        HashTable<Long, Book> books = this.handler.read();
        if (books == null) {
            books = new HashTable<>();
        }

        //Setando o id
        Long id = (long) books.size();
        id++;
        entity.setId(id);
        books.put(entity.getId(), entity);
        this.handler.save(books);
        
        books.clear();
        //Validando se o livro foi salvo
        books = this.handler.read();
        Book bookRead =books.get(entity.getId());
        if(bookRead.equals(entity))
            return true;
        else
            return false;

    }


    /**
     * Ler todos os livros contidos no arquivo binário
     * @return Retornar uma LinkedList com todos os livros do arquivo
     */
    @Override
    public LinkedListDouble<Book> read() {
        HashTable<Long, Book> books = this.handler.read();
        if (books == null) {
            throw new ReadException("Nenhum livro encontrado, lista de livros vazia ou inexistente");
        } else {
            LinkedListDouble<Book> bookReturn = new LinkedListDouble<>();
            for (Long i = 1L; i <= books.size(); i++){
                bookReturn.addLast(books.get(i));
            }
            return bookReturn;
        }
    }

    /**
     * Função que ler um livro específico no arquivo a partir do id
     * @param id id do livro
     * @return Livro do id indicado
     */
    public Book readBook(Long id) {
        HashTable<Long, Book> books = this.handler.read();
        if (books == null) {
            throw new ReadException("Nenhum livro encontrado, lista de livros vazia ou inexistente");
        } else {
            Book bookReturn = books.get(id);
            if(bookReturn == null){
                throw new ReadException("Nenhum livro encontrado, lista de livros vazia ou inexistente");
            }
            return bookReturn;
        }
    }

    /**
     * Função que faz o update do livro a partir de um id
     * @param id id do livro que vai ser atualizado
     * @param entity com as atualizações
     * @return booleano indicado se o livro do id informado foi atualizado com a entidade informada
     */
    @Override
    public boolean update(Long id, Book entity) {
        HashTable<Long, Book> books = this.handler.read();
        if (books == null) {
            throw new UpdateException("Nenhum livro encontrado, lista de livros vazia ou inexistente");
        } else {
            Book bookRead = books.get(id);
            if (bookRead == null) {
                throw new UpdateException("Livro não encontrado para essa chave");
            } else {
                entity.setId(id);
                books.put(id, entity);
                handler.save(books);
            }
            bookRead = books.get(id);
            if(bookRead.equals(entity) && bookRead.getId() == id)
                return true;
            else
                return false;
        }
    }

    /**
     * Função que remove um livro a partir do ID dele
     * @param id id do livro a ser excluido
     * @return retorna booleano indicando se o livro realmente foi excluido
     */
    @Override
    public boolean delete(Long id) {
        HashTable<Long, Book> books = this.handler.read();
        if (books.containsKey(id)) {
            books.remove(id);
            this.handler.save(books);
            return true;
        } else {
            throw new DeleteException("Livro não encontrado");
        }
    }

    /**
     * Função para listar pelo Nome
     * @param name nome a ser buscado
     * @return Lista duplamente encadeada contendo resultado da busca
     */

     public LinkedListDouble<Book> listByName(String name){
        LinkedListDouble<Book> bookers = read();
        LinkedListDouble<Book> result = new LinkedListDouble<>();
        for(int i = bookers.getSize() ; i > 0; i--){
            //verificando se a string passada contem no nome do livro
            if(bookers.peekFirst().getTitle().toLowerCase().contains(name.toLowerCase())){
                result.addLast(bookers.peekFirst());
                bookers.removeFirst();
            }else{
                bookers.removeFirst();
            }
        }
        return result;
    }

    /**
     * Função para listar pelo Autor
     * @param author autor a ser buscado
     * @return Lista duplamente encadeada contendo resultado da busca
     */

     public LinkedListDouble<Book> listByAuthor(String author){
        LinkedListDouble<Book> bookers = read();
        LinkedListDouble<Book> result = new LinkedListDouble<>();
        for(int i = bookers.getSize() ; i > 0; i--){
            //verificando se a string passada contem no author do livro
            if(bookers.peekFirst().getAuthor().toLowerCase().contains(author.toLowerCase())){
                result.addLast(bookers.peekFirst());
                bookers.removeFirst();
            }else{
                bookers.removeFirst();
            }
        }
        return result;
    }

    /**
     * Função para listar pela editora
     * @param publisher autor a ser buscado
     * @return Lista duplamente encadeada contendo resultado da busca
     */

     public LinkedListDouble<Book> listByPublisher(String publisher){
        LinkedListDouble<Book> bookers = read();
        LinkedListDouble<Book> result = new LinkedListDouble<>();
        for(int i = bookers.getSize() ; i > 0; i--){
            //verificando se a string passada contem na editora do livro
            if(bookers.peekFirst().getPublishe().toLowerCase().contains(publisher.toLowerCase())){
                result.addLast(bookers.peekFirst());
                bookers.removeFirst();
            }else{
                bookers.removeFirst();
            }
        }
        return result;
    }
    
    /**
     * Função para listar pela  categoria
     * @param category categoria a ser buscada
     * @return Lista duplamente encadeada contendo resultado da busca
     */

     public LinkedListDouble<Book> listByCategory(String category){
        LinkedListDouble<Book> bookers = read();
        LinkedListDouble<Book> result = new LinkedListDouble<>();
        for(int i = bookers.getSize() ; i > 0; i--){
            //verificando se a string passada contem no nome do livro
            if(bookers.peekFirst().getCategory().toLowerCase().contains(category.toLowerCase())){
                result.addLast(bookers.peekFirst());
                bookers.removeFirst();
            }else{
                bookers.removeFirst();
            }
        }
        return result;
    }
}
