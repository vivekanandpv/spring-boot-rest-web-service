package in.athenaeum.springbootrestwebservice.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String email;
    private String country;

    //  The default fetch is lazy (-to-many side).
    //  That means child table is queried when accessed
    //  This probably is the best approach for general situations
    @OneToMany(mappedBy = "publisher")
    private List<Book> books = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
