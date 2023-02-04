package com.example.focourseN.Repository;

import com.example.focourseN.Entity.Course;
import com.example.focourseN.Entity.CourseMaterial;
import com.example.focourseN.Entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    @Autowired
    private CourseRepository courserepository;

    @Test
    public void SaveCourseMaterial(){
        Course course = new Course("Chemistry",4);

        CourseMaterial courseMaterial = new CourseMaterial("www.yahii.com",course);

        repository.save(courseMaterial);


    }

    @Test
    public void printCourseMaterials(){
        List<CourseMaterial> materials = repository.findAll();

        System.out.println("courseMaterials = " + materials);

    }

    @Test
    public void printCourses(){
        List<Course> materials = courserepository.findAll();

        System.out.println("courses = " + materials);

    }

    @Test
    public void printFirstTwoCourses(){
        Pageable first2pages = PageRequest.of(0,2);
        List<Course> just2 = courserepository.findAll(first2pages).getContent();
        System.out.println("courses = "+ just2);

    }

    @Test
    public void printFirst2Courses(){
        Pageable first2pages = PageRequest.of(0,2, Sort.by("title").descending().and(Sort.by("credit")));
        List<Course> just2 = courserepository.findAll(first2pages).getContent();
        System.out.println("courses = "+ just2);

    }

    @Test
    public void saveWithTeacher(){
        Teacher teacher = new Teacher("Elochukwu","ordinary Staff");
        CourseMaterial material = new CourseMaterial("www.yahoo.com");
        Course course = new Course("Economics",3, teacher, material );
        courserepository.save(course);

    }


}