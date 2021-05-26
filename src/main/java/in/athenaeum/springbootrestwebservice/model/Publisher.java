package in.athenaeum.springbootrestwebservice.model;

import java.util.List;

public class Publisher {
    private int id;
    private String name;
    private String email;
    private String country;

    private List<Book> books;
}
