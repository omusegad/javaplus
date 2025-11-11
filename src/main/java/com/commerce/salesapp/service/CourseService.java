package com.commerce.salesapp.service;

import com.commerce.salesapp.model.Course;
import com.commerce.salesapp.repository.CourseRepository;
import com.commerce.salesapp.repository.LoanRepository;
import com.commerce.salesapp.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses(){
        return courseRepository.findAll() ;
    }

    public Course getCourse(long id){
        return courseRepository.findById(id).orElse(null);
    }

    public void createCourse(Course course){
        courseRepository.save(course);
    }

    public void deleteCourse(Long id){
        if(courseRepository.existsById(id)){
            courseRepository.deleteById(id);
        }
        throw new EntityNotFoundException("Course not found");
    }


}