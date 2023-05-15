package Tests;

import java.time.LocalDate;
import java.time.LocalDateTime;

import SRC.Model.VO.UserBook;
import Utils.BinaryPersisitence.BinaryUserBookHandler;
import Utils.ED.HashTable;

public class TestUserBookBinary {
    public static void main(String[] args) {

        BinaryUserBookHandler handler = new BinaryUserBookHandler("E://Documentos/UFERSA/Disciplinas/ED1/MinhaLeitura/MinhaLeitura/Tests/Bin/UserBookTest.bin");

        // Criando instâncias de UserBook
        UserBook ub1 = new UserBook(null, 1L, LocalDateTime.now(), null, 50, 4, "Muito bom", true);
        UserBook ub2 = new UserBook(null, 2L, LocalDateTime.now(), LocalDateTime.now(), 100, 5, "Excelente", false);
        UserBook ub3 = new UserBook(null, 3L, LocalDateTime.now(), LocalDateTime.now(), 10, 3, "Regular", false);

        // Criando a hash table
        HashTable<Long, UserBook> userBooks = new HashTable<>(10);
        userBooks.put(ub1.getBook(), ub1);
        userBooks.put(ub2.getBook(), ub2);
        userBooks.put(ub3.getBook(), ub3);

        // Salvando a hash table em um arquivo binário
        handler.save(userBooks);

        // Lendo a hash table a partir do arquivo binário
        HashTable<Long, UserBook> readUserBooks = handler.read();

        // Imprimindo a hash table original e a lida do arquivo binário
        System.out.println("UserBooks original:");
        System.out.println(userBooks);
        System.out.println("UserBooks lido do arquivo:");
        System.out.println(readUserBooks);
        
        
        for (Long i = 1L; i <= readUserBooks.size(); i++) {
        UserBook userBook = readUserBooks.get(i);
        System.out.println("Book: " + userBook.getBook());
        System.out.println("Start date: " + userBook.getStarDate());
        System.out.println("End date: " + userBook.getEndDate());
        System.out.println("Pages read: " + userBook.getPagesRead());
        System.out.println("Rating: " + userBook.getRating());
        System.out.println("Comment: " + userBook.getComment());
        System.out.println("Reading: " + userBook.isReading());
        System.out.println();   
    }

        // Verificando se as hash tables são iguais
        System.out.println("As hash tables são iguais? " + userBooks.equals(readUserBooks));

        // Deletando o arquivo binário
        handler.delete();

    }
}
