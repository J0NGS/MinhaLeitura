package SRC.Model.VO;

import java.io.Serializable;
import java.util.Objects;

import Utils.ED.HashTable;

public class UserReading implements Serializable{
    private Long userId;
    private HashTable<Long, UserBook> userBooks;


    public UserReading(Long userId, HashTable<Long,UserBook> userBooks) {
        this.userId = userId;
        this.userBooks = userBooks;
    }


    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public HashTable<Long,UserBook> getUserBooks() {
        return this.userBooks;
    }

    public void setUserBooks(HashTable<Long,UserBook> userBooks) {
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
