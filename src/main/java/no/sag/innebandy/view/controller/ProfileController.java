package no.sag.innebandy.view.controller;

import no.sag.innebandy.service.UserService;
import no.sag.innebandy.view.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@RestController
@RequestMapping("/innebandy/profile")
public class ProfileController
{
    @Autowired
    private UserService userService;

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public UserDto getUser(final Principal principal)
    {
        return userService.getUser(principal.getName());
    }
}
