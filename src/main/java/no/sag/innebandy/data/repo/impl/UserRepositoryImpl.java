package no.sag.innebandy.data.repo.impl;

import com.google.common.base.Preconditions;
import no.sag.innebandy.data.model.User;
import no.sag.innebandy.data.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository
{
    private static final String USERS_FIELDS = "u.username as u_username, u.email as u_email, u.enabled as u_enabled";
    private static final String ATTENDANCE_FIELDS = "a.id as a_id, a.username as a_username, a.date as a_date, a.type as a_type";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findByEnabled(final boolean enabled)
    {
        final String sql = new StringBuilder()
            .append("select")
            .append(" ").append(USERS_FIELDS)
            .append(", ").append(ATTENDANCE_FIELDS)
            .append(" ").append("from users as u")
            .append(" ").append("left join attendance as a")
            .append(" ").append("on u.username=a.username")
            .append(" ").append("where u.enabled=?")
            .append(" ").append("order by u.username")
            .toString();

        return jdbcTemplate.query(sql, new Object[] {enabled}, new UsersResultSetExtractor());
    }

    @Override
    public User findByUsernameAndEnabled(String username, boolean enabled)
    {
        Preconditions.checkNotNull(!StringUtils.isEmpty(username), "username is required");

        final String sql = new StringBuilder()
            .append("select")
            .append(" ").append(USERS_FIELDS)
            .append(",").append(ATTENDANCE_FIELDS)
            .append(" ").append("from users as u")
            .append(" ").append("left join attendance as a")
            .append(" ").append("on u.username=a.username")
            .append(" ").append("where u.username=?")
            .append(" ").append("and u.enabled=?")
            .append(" ").append("order by u.username")
            .toString();

        final List<User> users = jdbcTemplate.query(sql, new Object[] {enabled, username}, new UsersResultSetExtractor());

        if (users.size() != 1) {
            throw new IllegalStateException("Expected to find exactly one user with username=" + username);
        }

        return users.iterator().next();
    }
}
