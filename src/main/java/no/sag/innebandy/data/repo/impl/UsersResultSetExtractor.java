package no.sag.innebandy.data.repo.impl;

import no.sag.innebandy.data.model.Attendance;
import no.sag.innebandy.data.model.AttendanceType;
import no.sag.innebandy.data.model.User;
import no.sag.innebandy.util.TimeUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class UsersResultSetExtractor implements ResultSetExtractor<List<User>>
{
    @Override
    public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException
    {
        final Map<String, User> users = new HashMap<>();

        while (rs.next())
        {
            final Optional<Attendance> attendance = mapAttendance(rs);

            final String email = rs.getString("u_email");

            if (users.containsKey(email))
            {
                final User user = users.get(email);
                if (attendance.isPresent()) {
                    user.getAttendences().add(attendance.get());
                }
            }
            else
            {
                User user = createUser(rs, attendance);
                users.put(email, user);
            }
        }

        return users.values().stream()
            .sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
            .collect(Collectors.toList());
    }

    private Optional<Attendance> mapAttendance(final ResultSet rs) throws SQLException
    {
        if (rs.getObject("a_id") == null) {
            return Optional.empty();
        }
        Attendance attendance = new Attendance();
        attendance.setId(rs.getLong("a_id"));
        attendance.setDate(TimeUtil.convert(rs.getDate("a_date")));
        attendance.setAttendanceType(AttendanceType.valueOf(rs.getString("a_type")));
        return Optional.of(attendance);
    }

    private User createUser(final ResultSet rs, final Optional<Attendance> attendance) throws SQLException
    {
        User user = new User();
        user.setEmail(rs.getString("u_email"));
        user.setName(rs.getString("u_name"));
        user.setPhone(rs.getString("u_phone"));
        user.setEnabled(rs.getBoolean("u_enabled"));
        if (attendance.isPresent()) {
            user.getAttendences().add(attendance.get());
        }
        return user;
    }
}
