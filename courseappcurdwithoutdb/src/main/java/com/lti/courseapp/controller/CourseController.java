package com.lti.courseapp.controller;

import com.lti.courseapp.entity.Course;
import com.lti.courseapp.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    //get all course         http://localhost:8080/courses
    @GetMapping("/courses")
    public List<Course> getAllCourse() {

        //return courseService.getCourses();
        return this.courseService.getCourses();
    }
//http://localhost:8080/course/2
    @GetMapping("/course/{courseId}")
    public Course getCourse(@PathVariable(value = "courseId") String courseId) {
        return courseService.getCourse(Long.parseLong(courseId));
    }
    //http://localhost:8080/courses/1

    @GetMapping("/courses/{courseId}")
    public Course getSingleCourse(@PathVariable(value = "courseId") long courseId) {
        return courseService.getCourse(courseId);
    }
    @PostMapping("/addcourses")
    public List<Course> addCourse(@RequestBody Course course){

        return this.courseService.addCourse(course);

    }
    //update course
    @PutMapping("/course")
    public List<Course> updateCourse(@RequestBody Course course){
       return courseService.updateCourse(course);
    }

    //Delete Course
    @DeleteMapping("courses/{courseId}")
//    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable(value="courseId") long courseId)

    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable(value="courseId") String courseId)
    {
        try {
            //courseService.deleteCourse(courseId);

            courseService.deleteCourse(Long.parseLong(courseId));
            return  new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex){
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
