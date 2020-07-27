package bg.hristoskova.restservices.services;

import bg.hristoskova.restservices.models.entity.Course;
import bg.hristoskova.restservices.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CourseResource {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseResource(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping("/title")
    public String retrieveTitle() {
        return "Learn Angular and Spring Boot";
    }

    @GetMapping("/course")
    public Course retrieveCourse() {
        return new Course(1L, "Learn Angular and Spring Boot",
                new BigDecimal("299.99"),
                new Date(), 3);
    }

    @GetMapping("/courses")
    public List<Course> findAll() {
        return this.courseRepository.findAll();
    }

    @GetMapping("/courses/{id}")
    public Course findCourse(@PathVariable Long id) {
        return this.courseRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        Course course = this.courseRepository.findById(id).orElse(null);

        if (course == null) {
            return ResponseEntity.notFound().build();
        }

        this.courseRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity<Course> updateCourse(@RequestBody Course body, @PathVariable Long id) {
        Course course = this.courseRepository.findById(id).orElse(null);

        if (course == null) {
            return ResponseEntity.notFound().build();
        }

        Course updatedCourse = this.courseRepository.save(body);
        return new ResponseEntity<Course>(updatedCourse, HttpStatus.OK);
    }

    @PostMapping("/courses")
    public ResponseEntity<Course> createCourse(@RequestBody Course body) {
        Course createdCourse = this.courseRepository.save(body);

        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
    }

}
