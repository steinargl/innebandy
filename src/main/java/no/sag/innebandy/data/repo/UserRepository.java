package no.sag.innebandy.data.repo;

import no.sag.innebandy.data.model.User;

import java.util.List;

public interface UserRepository
{
    List<User> findByEnabled(boolean enabled);

    User findByEmail(String email);

    void update(String email, String name, String phone);
}
