package no.sag.treg.data.repo;

import no.sag.treg.data.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String>
{
    User findByEmail(String email);
}
