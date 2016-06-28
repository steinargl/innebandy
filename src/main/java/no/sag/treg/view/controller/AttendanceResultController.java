package no.sag.treg.view.controller;

import no.sag.treg.service.AttendanceResultService;
import no.sag.treg.service.AttendanceService;
import no.sag.treg.view.dto.AttendanceDto;
import no.sag.treg.view.dto.AttendanceResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/innebandy/attendance")
public class AttendanceResultController
{
    @Autowired
    private AttendanceResultService attendanceResultService;

    @Autowired
    private AttendanceService attendanceService;

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public AttendanceResultDto getAttendance(Principal principal)
    {
        return attendanceResultService.getAttendanceResult();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public AttendanceDto addAttendance(@RequestParam("id") final String attendanceTypeId)
    {
        return attendanceService.addAttendance(attendanceTypeId);
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
