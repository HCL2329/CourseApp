package com.lti.courseapp.services;

import com.lti.courseapp.entity.Course;

import java.util.List;

public interface CourseService {

    public List<Course> getCourses();

    public Course getCourse(long courseId);

    public List<Course> addCourse(Course course);

    public List<Course> updateCourse(Course course);

    public  void  deleteCourse(long courseId);

}
