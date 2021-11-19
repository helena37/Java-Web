package bg.hristoskova.judge1.service.impl;

import bg.hristoskova.judge1.model.entity.Homework;
import bg.hristoskova.judge1.model.service.HomeworkServiceModel;
import bg.hristoskova.judge1.repository.HomeworkRepository;
import bg.hristoskova.judge1.service.HomeworkService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;

/**
 * @author helena81
 * @version 1.0
 * @since 17.11.21
 */
@Service
public class HomeworkServiceImpl implements HomeworkService {
    private final HomeworkRepository homeworkRepository;
    private final ModelMapper modelMapper;

    public HomeworkServiceImpl(HomeworkRepository homeworkRepository, ModelMapper modelMapper) {
        this.homeworkRepository = homeworkRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void add(HomeworkServiceModel homeworkServiceModel) {
        this.homeworkRepository.saveAndFlush(this.modelMapper.map(homeworkServiceModel, Homework.class));
    }

    @Override
    public HomeworkServiceModel findOneToCheck() {
        return this.homeworkRepository
                .findAll()
                .stream()
                .min(Comparator.comparingInt(a -> a.getComments().size()))
                .map(homework -> this.modelMapper.map(homework, HomeworkServiceModel.class))
                .orElse(null);
    }

    @Override
    public HomeworkServiceModel findById(String homeworkId) {
        return this.homeworkRepository.findById(homeworkId)
                .map(homework -> this.modelMapper.map(homework, HomeworkServiceModel.class))
                .orElse(null);
    }
}
