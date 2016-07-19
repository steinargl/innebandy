package no.sag.innebandy.service.impl;

import com.google.common.base.Preconditions;
import no.sag.innebandy.data.model.User;
import no.sag.innebandy.data.repo.UserRepository;
import no.sag.innebandy.service.UserService;
import no.sag.innebandy.view.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto getUser(String username)
    {
        Preconditions.checkNotNull(username, "username is required");

        final User user =  userRepository.findByUsername(username);

        return UserDto.builder().build(user);
    }

    @Override
    public UserDto updateUser(String username, String newUserName, String email)
    {
        return null;
    }

    @Override
    public UserDto createUser(String username, String email)
    {
        return null;
    }
}
