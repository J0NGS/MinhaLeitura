package SRC.DAO;

import SRC.DAO.Exceptions.DeleteException;
import SRC.DAO.Exceptions.ReadException;
import SRC.DAO.Exceptions.UpdateException;
import SRC.VO.Book;
import Utils.BinaryPersisitence.BinaryBookHandler;
import Utils.ED.HashTable;

public class BookDAO implements DAOInterface<Book>{

    private BinaryBookHandler handler;

    public BookDAO() {
        this.handler = new BinaryBookHandler("E://Documentos/UFERSA/Disciplinas/ED1/MinhaLeitura/MinhaLeitura/Tests/Bin/BookDAO.bin");
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
    public Book read(Long id) {
        HashTable<Long, Book> books = this.handler.read();
        if (books == null) {
            throw new ReadException("Nenhum livro encontrado, lista de livros vazia ou inexistente");
        } else {
            Book bookReturn = books.get(id);
            if (bookReturn == null) {
                throw new ReadException("Livro não encontrado para essa chave");
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
