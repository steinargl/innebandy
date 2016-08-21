package no.sag.innebandy.data.repo.impl;

import com.google.common.base.Preconditions;
import no.sag.innebandy.data.model.User;
import no.sag.innebandy.data.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository
{
    private static final Logger LOG = LoggerFactory.getLogger(UserRepositoryImpl.class);

    private static final String USERS_FIELDS = "u.email as u_email, u.name as u_name, u.phone as u_phone, u.enabled as u_enabled";
    private static final String ATTENDANCE_FIELDS = "a.id as a_id, a.email as a_email, a.date as a_date, a.type as a_type";

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
            .append(" ").append("on u.email=a.email")
            .append(" ").append("where u.enabled=?")
            .append(" ").append("order by u.name")
            .toString();

        return jdbcTemplate.query(sql, new Object[] {enabled}, new UsersResultSetExtractor());
    }

    @Override
    public User findByEmail(final String email)
    {
        Preconditions.checkNotNull(!StringUtils.isEmpty(email), "email is required");

        final String sql = new StringBuilder()
            .append("select")
            .append(" ").append(USERS_FIELDS)
            .append(",").append(ATTENDANCE_FIELDS)
            .append(" ").append("from users as u")
            .append(" ").append("left join attendance as a")
            .append(" ").append("on u.email=a.email")
            .append(" ").append("where u.email=?")
            .append(" ").append("order by u.name")
            .toString();

        final List<User> users = jdbcTemplate.query(
            sql,
            new Object[] { email },
            new UsersResultSetExtractor()
        );

        if (users.size() != 1) {
            throw new IllegalStateException("Expected to find exactly one user with email/username=" + email);
        }

        return users.iterator().next();
    }

    @Override
    public void update(final String email, final String name, final String phone)
    {
        final String sql = "UPDATE users SET name=?, phone=? WHERE email=?";
        final Object[] params = new Object[] { name, phone, email };

        int recordsUpdated = jdbcTemplate.update(sql, params);

        if (recordsUpdated != 1)
        {
            LOG.error(String.format("Expected 1 row to be updated in users table, not %s, for user with email=%s", recordsUpdated, email));
        }
    }
}
