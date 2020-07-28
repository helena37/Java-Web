package bg.hristoskova.restservices.services;

import bg.hristoskova.restservices.models.entity.Course;

import java.util.List;

public interface CrudService<T, ID> {
    T save(T object);
    List<T> findAll();
    void deleteById(ID id);
    T findById(ID id);
    void delete(T object);
}
