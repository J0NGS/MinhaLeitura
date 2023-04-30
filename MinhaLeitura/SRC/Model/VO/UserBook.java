/*Classe que guarda os valores de Books pertecente ao user*/
//Autor: João Gonçalo
package SRC.Model.VO;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class UserBook implements Serializable{
    private Long book;                  // id do book
    private Long userId;                // id do user proprietário
    private LocalDateTime starDate;     // data de inicio de leitura
    private LocalDateTime endDate;      // data de termino de leitura
    private int pagesRead;              // paginas lidas
    private int rating;                 // raqueamento (1-5)
    private String comment;             // comentário
    private boolean reading;            // se a leitura ainda está ocorrendo


    // Construtor com todas as classes
    public UserBook(Long book,Long userId , LocalDateTime starDate, LocalDateTime endDate, int pagesRead, int rating, String comment, boolean reading) {
        this.book = book;
        this.userId = userId;
        this.starDate = starDate;
        this.endDate = endDate;
        this.pagesRead = pagesRead;
        this.rating = rating;
        this.comment = comment;
        this.reading = reading; 
    }

    // construtor sem classes
    public UserBook() {
    }

    /*
     * --------------------------------------------------------------------
     * Getters e Setters
     * --------------------------------------------------------------------
     */ 
    public Long getBook() {
        return this.book;
    }

    public void setBook(Long book) {
        this.book = book;
    }

    public LocalDate getStarDate() {
        return this.starDate;
    }

    public void setStarDate(LocalDate starDate) {
        this.starDate = starDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getPagesRead() {
        return this.pagesRead;
    }

    public void setPagesRead(int pagesRead) {
        this.pagesRead = pagesRead;
    }

    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    public boolean isReading() {
        return this.reading;
    }


    public void setReading(boolean reading) {
        this.reading = reading;
    }


    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean getReading() {
        return this.reading;
    }
    // --------------------------------------------------------------------
    // Equals e Hashcode
    // --------------------------------------------------------------------
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserBook)) {
            return false;
        }
        UserBook userBook = (UserBook) o;
        return Objects.equals(book, userBook.book) && Objects.equals(starDate, userBook.starDate) && Objects.equals(endDate, userBook.endDate) && pagesRead == userBook.pagesRead && rating == userBook.rating && Objects.equals(comment, userBook.comment) && reading == userBook.reading;
    }

    @Override
    public int hashCode() {
        return Objects.hash(book, starDate, endDate, pagesRead, rating, comment, reading);
    }


}
