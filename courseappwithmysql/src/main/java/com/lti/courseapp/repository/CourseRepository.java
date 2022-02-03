package com.lti.courseapp.repository;

import com.lti.courseapp.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {

}
