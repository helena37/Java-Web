package bg.hristoskova.judge1.service;

import bg.hristoskova.judge1.model.service.ExerciseServiceModel;

import java.util.List;

/**
 * @author helena81
 * @version 1.0
 * @since 16.11.21
 */
public interface ExerciseService {
    void addExercise(ExerciseServiceModel exerciseServiceModel);

    List<String> findAllExercisesNames();

    ExerciseServiceModel findByName(String exercise);
}
