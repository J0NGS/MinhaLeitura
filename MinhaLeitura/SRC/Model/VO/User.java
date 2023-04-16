/*Classe que guarda os valores de user*/
//Autor: João Gonçalo
package SRC.Model.VO;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable{
    private Long id;                // id
    private String username;        // username
    private String password;        // senha
    private String email;           // email
    private String name;            // nome

    // Construtor com todas os atributos
    public User(Long id, String username, String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }

    // Construtor com dois atributos
    public User(String username, String password){
        this.id = 0L;
        this.username = username;
        this.password = password;
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

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //--------------------------------------------------------------------
    //Equals e hashcode
    //--------------------------------------------------------------------
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return  Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
