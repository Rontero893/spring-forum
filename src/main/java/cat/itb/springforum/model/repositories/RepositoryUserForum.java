package cat.itb.springforum.model.repositories;

import cat.itb.springforum.model.entities.UserForum;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryUserForum extends CrudRepository<UserForum, Long>
{

}
