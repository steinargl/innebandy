package no.sag.innebandy.view.controller;

import no.sag.innebandy.data.model.AttendanceType;
import no.sag.innebandy.service.TrainingService;
import no.sag.innebandy.service.AttendanceService;
import no.sag.innebandy.view.dto.TrainingDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/innebandy/attendance")
public class TrainingController
{
    private static final Logger LOG = LoggerFactory.getLogger(TrainingController.class);

    @Autowired
    private TrainingService trainingService;

    @Autowired
    private AttendanceService attendanceService;

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public TrainingDto getAttendance(final Principal principal)
    {
        final TrainingDto trainingDto = trainingService.getTraining(principal.getName());
        return trainingDto;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public TrainingDto createAttendance(
        final Principal principal,
        @RequestParam("attendanceTypeId") final String attendanceTypeId)
    {
        attendanceService.createAttendance(principal.getName(), AttendanceType.valueOf(attendanceTypeId));

        final TrainingDto trainingDto = trainingService.getTraining(principal.getName());

        LOG.info(String.format("User=%s attendanceTypeId=%s participant=%s", principal.getName(), attendanceTypeId, trainingDto.getAttendingList().size()));

        return trainingDto;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public TrainingDto updateAttendance(
        final Principal principal,
        @RequestParam("attendanceId") final Long attendanceId,
        @RequestParam("attendanceTypeId") final String attendanceTypeId)
    {
        attendanceService.updateAttendance(attendanceId, AttendanceType.valueOf(attendanceTypeId));

        final TrainingDto trainingDto = trainingService.getTraining(principal.getName());

        LOG.info(String.format("User=%s attendanceTypeId=%s participant=%s", principal.getName(), attendanceTypeId, trainingDto.getAttendingList().size()));

        return trainingDto;
    }
}
