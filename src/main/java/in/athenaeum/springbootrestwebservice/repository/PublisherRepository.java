package in.athenaeum.springbootrestwebservice.repository;

import in.athenaeum.springbootrestwebservice.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
}
