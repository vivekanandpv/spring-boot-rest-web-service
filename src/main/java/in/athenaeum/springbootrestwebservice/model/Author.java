package in.athenaeum.springbootrestwebservice.model;

import java.util.Set;

public class Author {
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    private Set<Book> books;
}
