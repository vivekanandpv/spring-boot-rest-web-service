package in.athenaeum.springbootrestwebservice.repository;

import in.athenaeum.springbootrestwebservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    //  Derived queries are the most appreciated features of Spring Data JPA
    //  Derived query methods start with: find, query, read, count, get
    //  IntelliJ offers an excellent support for derived queries.

    //  Comparison: Like, Containing, Between, GreaterThan, etc.

    //  OrderBy<Attr>Asc/OrderBy<Attr>Desc

    //  To limit: First<N>By, Top<N>By

    List<Book> findBookByTitle(String title);
    Optional<Book> findFirstByTitleAndNPages(String title, int nPages);
}
