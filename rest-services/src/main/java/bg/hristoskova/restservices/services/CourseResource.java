package bg.hristoskova.restservices.services;

import bg.hristoskova.restservices.models.entity.Course;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class CourseResource {
    private final CourseService courseService;

    public CourseResource(CourseService courseService) {
        this.courseService = courseService;
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
        return this.courseService.findAll();
    }

    @GetMapping("/courses/{id}")
    public Course findCourse(@PathVariable Long id) {
        return this.courseService.findById(id);
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        Course course = this.courseService.findById(id);

        if (course == null) {
            return ResponseEntity.notFound().build();
        }

        this.courseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity<Course> updateCourse(@RequestBody Course body, @PathVariable Long id) {
        Course course = this.courseService.findById(id);

        if (course == null) {
            return ResponseEntity.notFound().build();
        }

        Course updatedCourse = this.courseService.save(body);
        return new ResponseEntity<Course>(updatedCourse, HttpStatus.OK);
    }

    @PostMapping("/courses")
    public ResponseEntity<Course> createCourse(@RequestBody Course body) {
        Course createdCourse = this.courseService.save(body);

        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
    }

}
