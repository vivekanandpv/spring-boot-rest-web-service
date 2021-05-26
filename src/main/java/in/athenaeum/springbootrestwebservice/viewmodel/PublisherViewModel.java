package in.athenaeum.springbootrestwebservice.viewmodel;

import java.util.ArrayList;
import java.util.List;

public class PublisherViewModel {
    private int id;
    private String name;
    private String email;
    private String country;

    private List<BookViewModel> books = new ArrayList<>();
}
