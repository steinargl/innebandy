package no.sag.innebandy.data.repo.impl;

import com.google.common.base.Preconditions;
import no.sag.innebandy.data.model.AttendanceType;
import no.sag.innebandy.data.repo.AttendanceRepository;
import no.sag.innebandy.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class AttendanceRepositoryImpl implements AttendanceRepository
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(final String email, final LocalDate date, final AttendanceType attendanceType)
    {
        Preconditions.checkNotNull(email, "email is required");
        Preconditions.checkNotNull(attendanceType, "attendanceType is required");

        final String sql = "INSERT INTO attendance (email, date, type) values (?,?,?)";
        final Object[] params = new Object[] { email, TimeUtil.convert(date), attendanceType.name() };

        jdbcTemplate.update(sql, params);
    }

    @Override
    public void update(final Long id, final AttendanceType attendanceType)
    {
        Preconditions.checkNotNull(id, "id is required");
        Preconditions.checkNotNull(attendanceType, "attendanceType is required");

        final String sql = "UPDATE attendance SET type=? WHERE id=?";
        final Object[] params = new Object[] { attendanceType.name(), id };

        jdbcTemplate.update(sql, params);
    }
}
