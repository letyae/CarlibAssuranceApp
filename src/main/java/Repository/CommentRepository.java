package Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import model.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {

}