package no.sag.innebandy.data.repo;

import no.sag.innebandy.data.model.User;

import java.util.List;

public interface UserRepository
{
    List<User> findByEnabled(boolean enabled);

    User findByUsernameAndEnabled(String username, boolean enabled);
}
