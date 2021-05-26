package in.athenaeum.springbootrestwebservice.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String email;
    private String country;

    @OneToMany(mappedBy = "publisher")
    private List<Book> books;
}
