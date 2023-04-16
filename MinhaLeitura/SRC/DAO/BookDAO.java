package SRC.DAO;

import SRC.DAO.Exceptions.DeleteException;
import SRC.DAO.Exceptions.ReadException;
import SRC.DAO.Exceptions.UpdateException;
import SRC.Model.VO.Book;
import Utils.BinaryPersisitence.BinaryBookHandler;
import Utils.ED.HashTable;
import Utils.ED.LinkedListDouble;

public class BookDAO implements DAOInterface<Book>{

    private BinaryBookHandler handler;

    public BookDAO() {
        this.handler = new BinaryBookHandler("/home/jota/Documentos/MinhaLeitura/MinhaLeitura/Tests/Bin/book.bin");
    }

    @Override
    public boolean create(Book entity) {
        HashTable<Long, Book> books = this.handler.read();
        if (books == null) {
            books = new HashTable<>();
        }
        books.put(entity.getId(), entity);
        this.handler.save(books);
        books.clear();
        books = this.handler.read();
        return books.containsKey(entity.getId());
    }

    @Override
    public LinkedListDouble<Book> read() {
        HashTable<Long, Book> books = this.handler.read();
        if (books == null) {
            throw new ReadException("Nenhum livro encontrado, lista de livros vazia ou inexistente");
        } else {
            LinkedListDouble<Book> bookReturn = new LinkedListDouble<>();
            for (Long i = 0L; i < books.size(); i++){
                bookReturn.addLast(books.get(i));
            }
            return bookReturn;
        }
    }

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
                books.put(id, entity);
                handler.save(books);
            }
            bookRead = books.get(id);
            return bookRead.equals(entity);
        }
    }

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
}
