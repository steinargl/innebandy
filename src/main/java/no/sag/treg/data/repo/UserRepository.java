package no.sag.treg.data.repo;

import no.sag.treg.data.model.User;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Set;

public interface UserRepository extends CrudRepository<User, String>
{
    Set<User> findByEnabled(boolean enabled);

    User findByUsernameAndEnabled(String username, boolean enabled);
}
