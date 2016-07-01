package no.sag.treg.service;

import no.sag.treg.view.dto.TrainingStatus;

public interface TrainingStatusService
{
    TrainingStatus getStatus(int isAttendingCount, int limit);
}
