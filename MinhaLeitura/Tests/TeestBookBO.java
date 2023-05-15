package Tests;

import java.time.LocalDate;

import SRC.Model.BO.BookBO;
import SRC.Model.DAO.BookDAO;
import SRC.Model.VO.Book;

public class TeestBookBO {
    public static void main(String[] args) {
    BookBO test = new BookBO();
    Book book2 = test.findBookByName("O Capital");
    System.out.println(book2.getTitle());
    System.out.println(book2.getId());
    }
}
