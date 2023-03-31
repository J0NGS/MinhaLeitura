package SRC.VO;

import java.util.Objects;

import Utils.ED.HashTable;

public class UserReading {
    private Long userId;
    private HashTable<Long, Book> userBooks;


    public UserReading(Long userId, HashTable<Long,Book> userBooks) {
        this.userId = userId;
        this.userBooks = userBooks;
    }


    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public HashTable<Long,Book> getUserBooks() {
        return this.userBooks;
    }

    public void setUserBooks(HashTable<Long,Book> userBooks) {
        this.userBooks = userBooks;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserReading)) {
            return false;
        }
        UserReading userReading = (UserReading) o;
        return Objects.equals(userId, userReading.userId) && Objects.equals(userBooks, userReading.userBooks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    
}
