package no.sag.innebandy.service.impl;

import com.google.common.base.Preconditions;
import no.sag.innebandy.data.model.Attendance;
import no.sag.innebandy.data.model.User;
import no.sag.innebandy.data.repo.UserRepository;
import no.sag.innebandy.service.CalendarService;
import no.sag.innebandy.service.UserService;
import no.sag.innebandy.view.dto.UserDto;
import no.sag.innebandy.view.dto.UserValidationResult;
import no.sag.innebandy.view.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CalendarService calendarService;

    @Override
    public UserDto getUser(final String email)
    {
        Preconditions.checkArgument(!StringUtils.isEmpty(email), "email is required");

        final User user = userRepository.findByEmail(email);
        final LocalDate nextTrainingDate = calendarService.nextTrainingDate();
        final Optional<Attendance> attendance =
                user.getAttendance(a -> a.getDate().equals(nextTrainingDate));

        if (attendance.isPresent()) {
            return UserDto.builder().build(user, attendance.get());
        }

        return UserDto.builder().build(user);
    }

    @Override
    public UserDto updateUser(String email, String name, String phone)
    {
        Preconditions.checkArgument(!StringUtils.isEmpty(email), "email is required");

        final UserValidator validator = new UserValidator();
        final UserValidationResult validationResult = validator.validate(name, phone);

        if (validationResult.getErrors()) {
            return UserDto.builder().email(email).name(name).phone(phone).validationResult(validationResult).build();
        }

        userRepository.update(email, name, phone);

        final LocalDate nextTrainingDate = calendarService.nextTrainingDate();
        final User user =  userRepository.findByEmail(email);
        final Optional<Attendance> attendance = user.getAttendance(a -> a.getDate().equals(nextTrainingDate));

        if (attendance.isPresent())
        {
            return UserDto.builder().validationResult(validationResult).build(user, attendance.get());
        }

        return UserDto.builder().validationResult(validationResult).build(user);
    }
}
