package com.example.focourseN.Repository;

import com.example.focourseN.Entity.Course;
import com.example.focourseN.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
