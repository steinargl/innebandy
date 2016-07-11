package no.sag.treg.data.repo;

import no.sag.treg.data.model.User;

import java.util.List;

public interface UserRepository
{
    List<User> findByEnabled(boolean enabled);

    User findByUsernameAndEnabled(String username, boolean enabled);
}
