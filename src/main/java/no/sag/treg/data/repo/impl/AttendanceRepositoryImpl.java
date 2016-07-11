package no.sag.treg.data.repo.impl;

import no.sag.treg.data.model.AttendanceType;
import no.sag.treg.data.repo.AttendanceRepository;
import no.sag.treg.util.TimeUtil;
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
    public void save(final String username, final LocalDate date, final AttendanceType attendanceType)
    {
        final String sql = "INSERT INTO attendance (username, date, type) values (?,?,?)";
        final Object[] params = new Object[] { username, TimeUtil.convert(date), attendanceType.name() };

        jdbcTemplate.update(sql, params);
    }

    @Override
    public void update(final Long id, final AttendanceType attendanceType)
    {
        final String sql = "UPDATE attendance SET type=? WHERE id=?";
        final Object[] params = new Object[] { attendanceType.name(), id };

        jdbcTemplate.update(sql, params);
    }
}
