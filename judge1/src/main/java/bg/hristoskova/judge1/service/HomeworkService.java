package bg.hristoskova.judge1.service;

import bg.hristoskova.judge1.model.service.HomeworkServiceModel;

/**
 * @author helena81
 * @version 1.0
 * @since 17.11.21
 */
public interface HomeworkService {
    void add(HomeworkServiceModel homeworkServiceModel);

    HomeworkServiceModel findOneToCheck();

    HomeworkServiceModel findById(String homeworkId);
}
