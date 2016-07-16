package no.sag.innebandy.service;

import no.sag.innebandy.view.dto.TrainingStatus;

public interface TrainingStatusService
{
    TrainingStatus getStatus(int isAttendingCount, int limit);
}
