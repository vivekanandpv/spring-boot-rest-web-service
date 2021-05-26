package in.athenaeum.springbootrestwebservice.model;

import java.util.Set;

public class Book {
    private int id;
    private String title;
    private int nPages;
    private double price;

    private Publisher publisher;

    private Set<Author> authors;
}
