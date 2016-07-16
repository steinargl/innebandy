package no.sag.innebandy.view.controller;

import no.sag.innebandy.data.model.AttendanceType;
import no.sag.innebandy.service.TrainingService;
import no.sag.innebandy.service.AttendanceService;
import no.sag.innebandy.view.dto.TrainingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/innebandy/attendance")
public class TrainingController
{
    @Autowired
    private TrainingService trainingService;

    @Autowired
    private AttendanceService attendanceService;

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public TrainingDto getAttendance(final Principal principal)
    {
        return trainingService.getTraining(principal.getName());
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public TrainingDto createAttendance(final Principal principal, @RequestParam("attendanceTypeId") final String attendanceTypeId)
    {
        attendanceService.createAttendance(principal.getName(), AttendanceType.valueOf(attendanceTypeId));
        return trainingService.getTraining(principal.getName());
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public TrainingDto updateAttendance(
        final Principal principal,
        @RequestParam("attendanceId") final Long attendanceId,
        @RequestParam("attendanceTypeId") final String attendanceTypeId)
    {
        attendanceService.updateAttendance(attendanceId, AttendanceType.valueOf(attendanceTypeId));
        return trainingService.getTraining(principal.getName());
    }

  /*  @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteActivity(@RequestParam("id") final Long activityId)
    {
        activityService.deleteActivity(activityId);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/move", method = RequestMethod.PUT)
    public AttendanceDto moveToTomorrow(
        @RequestParam("id") final Long activityId)
    {
        return activityService.moveToTomorrow(activityId);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public AttendanceDto updateActivity(final ActivityForm form)
    {
        return activityService.updateActivity(
            form.getActivityId(),
            form.getActivityTypeId(),
            form.getHours(),
            form.getMinutes(),
            form.getDescription());
    }*/


}
