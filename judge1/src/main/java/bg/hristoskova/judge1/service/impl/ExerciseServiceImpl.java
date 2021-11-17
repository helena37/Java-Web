package bg.hristoskova.judge1.service.impl;

import bg.hristoskova.judge1.model.entity.Exercise;
import bg.hristoskova.judge1.model.service.ExerciseServiceModel;
import bg.hristoskova.judge1.repository.ExerciseRepository;
import bg.hristoskova.judge1.service.ExerciseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * @author helena81
 * @version 1.0
 * @since 16.11.21
 */
@Service
public class ExerciseServiceImpl implements ExerciseService {
    private final ExerciseRepository exerciseRepository;
    private final ModelMapper modelMapper;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository, ModelMapper modelMapper) {
        this.exerciseRepository = exerciseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addExercise(ExerciseServiceModel exerciseServiceModel) {
        this.exerciseRepository.saveAndFlush(this.modelMapper.map(exerciseServiceModel, Exercise.class));
    }
}
