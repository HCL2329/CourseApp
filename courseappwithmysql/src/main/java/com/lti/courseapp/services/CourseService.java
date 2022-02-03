package com.lti.courseapp.services;

import com.lti.courseapp.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    public List<Course> getCourses();

    public Optional<Course> getCourse(long courseId);

    public Course addCourse(Course course);

    public Course updateCourse(Course course);

    public  void  deleteCourse(long courseId);

}
