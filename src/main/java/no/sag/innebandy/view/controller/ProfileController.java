package no.sag.innebandy.view.controller;

import no.sag.innebandy.service.UserService;
import no.sag.innebandy.view.dto.TrainingDto;
import no.sag.innebandy.view.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/innebandy/profile")
public class ProfileController
{
    @Autowired
    private UserService userService;

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public UserDto getAttendance(final Principal principal)
    {
        return userService.getUser(principal.getName());
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public UserDto savetUser(
            final Principal principal,
            @RequestParam("email") final String email,
            @RequestParam("name") final String name,
            @RequestParam("phone") final String phone)
    {
        return userService.updateUser(email, name, phone);
    }
}
