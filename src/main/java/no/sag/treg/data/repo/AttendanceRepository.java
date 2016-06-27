package no.sag.treg.data.repo;

import no.sag.treg.data.model.Attendance;
import org.springframework.data.repository.CrudRepository;

public interface AttendanceRepository extends CrudRepository<Attendance, String>
{
}
