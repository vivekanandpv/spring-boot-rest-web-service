package in.athenaeum.springbootrestwebservice.repository;

import in.athenaeum.springbootrestwebservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    //  When @Query is used, the more efficient or flexible query can be constructed
    //  especially useful in complex situations.

    //  JPQL (Java Persistence Query Language) queries are database agnostic, are
    //  easy to reason about (domain model as opposed to the table structure), but
    //  do not support complete SQL. In extreme cases, writing native queries makes
    //  more sense.

    //  More info:
    //  https://docs.oracle.com/html/E13946_04/ejb3_langref.html
    //  https://docs.oracle.com/javaee/6/tutorial/doc/bnbtg.html

    @Query("FROM Book where title= ?1")
        //?1 is the positional bind parameter
    List<Book> findByTitle(String title);

    @Query("FROM Book where title = ?1 and nPages >= ?2")
    List<Book> findByTitleAndPages(String title, int minPages);

    //  for sorting ORDER BY <Attr> ASC/DESC

    //  Projection
    @Query("SELECT b FROM Book b where b.title = ?1 and b.nPages >= ?2")
    List<Book> findByTitleAndPagesAnother(String title, int minPages);

    @Query("SELECT b FROM Book b where b.title = :title and b.nPages >= :minPages")
    List<Book> findByTitleAndPagesNamedBindParameters(@Param("title") String title, @Param("minPages") int minPages);


    //  Native queries
    @Query(value = "SELECT * FROM book WHERE title LIKE :title", nativeQuery = true)
    List<Book> findByTitleNative(@Param("title") String title);
}
