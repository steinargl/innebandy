package no.sag.innebandy.service;

import no.sag.innebandy.view.dto.UserDto;

public interface UserService
{
    UserDto getUser(String username);

    UserDto updateUser(String username, String newUserName, String email);

    UserDto createUser(String username, String email);
}
