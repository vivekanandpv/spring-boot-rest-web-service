package in.athenaeum.springbootrestwebservice.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private int nPages;
    private double price;

    //  The default fetch is eager here (-to-one side).
    //  That means Parent table is queried eagerly
    //  This probably is the best approach for general situations
    @ManyToOne(optional = false)  //  this is optional=true by default. Watch out!
    private Publisher publisher;    //publisher_id

    @Column(name = "publisher_id", insertable = false, updatable = false)
    private int publisherId;

    //  The default fetch is lazy (-to-many side).
    //  That means child table is queried when accessed
    //  This probably is the best approach for general situations
    @ManyToMany(mappedBy = "books")
    private Set<Author> authors = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getnPages() {
        return nPages;
    }

    public void setnPages(int nPages) {
        this.nPages = nPages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}
