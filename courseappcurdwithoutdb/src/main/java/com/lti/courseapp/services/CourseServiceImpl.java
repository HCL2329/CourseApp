package com.lti.courseapp.services;

import com.lti.courseapp.entity.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService{

    List<Course> courses;

    public  CourseServiceImpl(){
        courses=new ArrayList<>();
        courses.add(new Course(1,"Java","For beginners"));
        courses.add(new Course(2,"C++","For beginners"));

        courses.add(new Course(3,"C#","For beginners"));

        courses.add(new Course(4,"Python","For beginners"));

    }

    @Override
    public List<Course> getCourses() {



        return courses;
    }

    @Override
    public Course getCourse(long courseId) {
        Course c=null;
        for(Course course:courses){
            if(course.getId()==courseId)
            {
                c=course;
                break;
            }
        }
        return c;
    }

    @Override
    public List<Course> addCourse(Course course) {
        courses.add(course);
        return courses;
    }

    @Override
    public List<Course> updateCourse(Course course) {
        courses.forEach(e->{

            if(e.getId()==course.getId()){
                e.setTitle(course.getTitle());
                e.setDescription(course.getDescription());
            }
        });
        return courses;
    }

    @Override
    public void deleteCourse(long courseId) {
courses=this.courses.stream().filter(e->e.getId()!=courseId).collect(Collectors.toList());
    }
}
