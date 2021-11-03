package az.askyard.askyardws.dataAccess.abstracts;

import az.askyard.askyardws.entities.concretes.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
}
