package cat.itb.springforum.model.repositories;

import cat.itb.springforum.model.entities.Feedback;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryFeedback extends CrudRepository<Feedback, Long>
{

}