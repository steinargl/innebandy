package no.sag.treg.service;

import no.sag.treg.view.dto.TrainingDto;

public interface TrainingService
{
    TrainingDto getTraining(final String username);
}
