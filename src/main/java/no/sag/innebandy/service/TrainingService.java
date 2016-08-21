package no.sag.innebandy.service;

import no.sag.innebandy.view.dto.TrainingDto;

public interface TrainingService
{
    TrainingDto getTraining(final String email);
}
