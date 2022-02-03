package com.lti.courseapp.services;

import com.lti.courseapp.entity.Course;
import com.lti.courseapp.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;
    public  CourseServiceImpl(){}

    /*List<Course> courses;

    public  CourseServiceImpl(){
        courses=new ArrayList<>();
        courses.add(new Course(1,"Java","For beginners"));
        courses.add(new Course(2,"C++","For beginners"));

        courses.add(new Course(3,"C#","For beginners"));

        courses.add(new Course(4,"Python","For beginners"));

    }*/

    @Override
    public List<Course> getCourses() {

        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> getCourse(long courseId) {
      /*  Course c=null;
        for(Course course:courses){
            if(course.getId()==courseId)
            {
                c=course;
                break;
            }
        }*/
        return courseRepository.findById(courseId);
    }

    @Override
    public Course addCourse(Course course) {
        //courses.add(course);
        Course newCourse = courseRepository.save(course);
        return newCourse;
    }

    @Override
    public Course updateCourse(Course course) {
       /* courses.forEach(e->{

            if(e.getId()==course.getId()){
                e.setTitle(course.getTitle());
                e.setDescription(course.getDescription());
            }
        });*/
        Course updateCourse = courseRepository.save(course);
        return updateCourse;
    }

    @Override
    public void deleteCourse(long courseId) {

        //courses=this.courses.stream().filter(e->e.getId()!=courseId).collect(Collectors.toList());
        Course entityId = courseRepository.getById(courseId);
        courseRepository.delete(entityId);
    }
}
