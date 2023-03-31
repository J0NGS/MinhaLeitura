package SRC.VO;

import java.time.LocalDate;
import java.util.Objects;

public class UserBook {
    private Long book;
    private Long user;
    private LocalDate starDate;
    private LocalDate endDate;
    private int pagesRead;
    private int rating;
    private String comment;


    public UserBook(Long book, Long user, LocalDate starDate, LocalDate endDate, int pagesRead, int rating, String comment) {
        this.book = book;
        this.user = user;
        this.starDate = starDate;
        this.endDate = endDate;
        this.pagesRead = pagesRead;
        this.rating = rating;
        this.comment = comment;
    }


    public Long getBook() {
        return this.book;
    }

    public void setBook(Long book) {
        this.book = book;
    }

    public Long getUser() {
        return this.user;
    }

    public void setUser(Long user) {
        this.user = user;
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
