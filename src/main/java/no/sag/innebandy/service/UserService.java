package no.sag.innebandy.service;

import no.sag.innebandy.view.dto.UserDto;

public interface UserService
{
    UserDto getUser(String email);

    UserDto updateUser(String email, String name, String phone);
}
