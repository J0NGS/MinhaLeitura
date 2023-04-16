/*Classe que guarda os valores do livro*/
//Autor: João Gonçalo
package SRC.Model.VO;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


public class Book implements Serializable{
    private Long id;                    // id
    private String title;               // titulo do livro
    private String author;              // autor
    private String publishe;            // editora
    private LocalDate releaseDate;      // data de lançamento
    private String category;            // categoria


    // Construtor usando todos os argumentos
    public Book(Long id, String title, String author, String publishe, LocalDate releaseDate, String category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishe = publishe;
        this.releaseDate = releaseDate;
        this.category = category;
    }

    /*
     * --------------------------------------------------------------------
     * Getters e Setters
     * --------------------------------------------------------------------
     */
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishe() {
        return this.publishe;
    }

    public void setPublishe(String publishe) {
        this.publishe = publishe;
    }

    public LocalDate getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    //--------------------------------------------------------------------
    // Equals e hashcode
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Book)) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(publishe, book.publishe) && Objects.equals(releaseDate, book.releaseDate) && Objects.equals(category, book.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
