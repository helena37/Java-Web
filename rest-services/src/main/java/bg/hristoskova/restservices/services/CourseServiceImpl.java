package bg.hristoskova.restservices.services;

import bg.hristoskova.restservices.models.entity.Course;
import bg.hristoskova.restservices.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course save(Course course) {
        return this.courseRepository.save(course);
    }

    @Override
    public List<Course> findAll() {
        return this.courseRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        this.courseRepository.deleteById(id);
    }

    @Override
    public Course findById(Long id) {
        return this.courseRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Course course) {
        this.courseRepository.delete(course);
    }
}
