package bg.hristoskova.judge1.service.impl;

import bg.hristoskova.judge1.model.entity.Comment;
import bg.hristoskova.judge1.model.service.CommentServiceModel;
import bg.hristoskova.judge1.repository.CommentRepository;
import bg.hristoskova.judge1.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * @author helena81
 * @version 1.0
 * @since 19.11.21
 */
@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;

    public CommentServiceImpl(CommentRepository commentRepository, ModelMapper modelMapper) {
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void add(CommentServiceModel commentServiceModel) {
        this.commentRepository.saveAndFlush(this.modelMapper.map(commentServiceModel, Comment.class));
    }
}
