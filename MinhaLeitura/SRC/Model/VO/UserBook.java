package SRC.Model.VO;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class UserBook implements Serializable{
    private Long book;
    private LocalDate starDate;
    private LocalDate endDate;
    private int pagesRead;
    private int rating;
    private String comment;
    private boolean reading;

    private User user;



    public UserBook(Long book, LocalDate starDate, LocalDate endDate, int pagesRead, int rating, String comment, boolean reading) {
        this.book = book;
        this.starDate = starDate;
        this.endDate = endDate;
        this.pagesRead = pagesRead;
        this.rating = rating;
        this.comment = comment;
        this.reading = reading;
    }


    public UserBook() {
    }


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


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserBook)) {
            return false;
        }
        UserBook userBook = (UserBook) o;
        return Objects.equals(book, userBook.book) && Objects.equals(user, userBook.user) && Objects.equals(starDate, userBook.starDate) && Objects.equals(endDate, userBook.endDate) && pagesRead == userBook.pagesRead && rating == userBook.rating && Objects.equals(comment, userBook.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book, user);
    }

}
