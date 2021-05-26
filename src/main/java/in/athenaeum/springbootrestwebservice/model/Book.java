package in.athenaeum.springbootrestwebservice.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private int nPages;
    private double price;

    @ManyToOne
    private Publisher publisher;    //publisher_id

    @Column(name = "publisher_id", insertable = false, updatable = false)
    private int publisherId;

    @ManyToMany(mappedBy = "books")
    private Set<Author> authors;
}
