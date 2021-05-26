package in.athenaeum.springbootrestwebservice.viewmodel;

import java.util.List;

public class BookViewModel {
    private int id;
    private String title;
    private int nPages;
    private double price;

    private PublisherViewModel publisher;

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

    public PublisherViewModel getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherViewModel publisher) {
        this.publisher = publisher;
    }
}
