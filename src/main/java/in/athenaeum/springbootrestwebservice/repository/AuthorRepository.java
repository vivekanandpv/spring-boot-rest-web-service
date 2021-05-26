package in.athenaeum.springbootrestwebservice.repository;

import in.athenaeum.springbootrestwebservice.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
