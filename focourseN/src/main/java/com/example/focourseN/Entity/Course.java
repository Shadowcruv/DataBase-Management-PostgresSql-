package com.example.focourseN.Entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Data
//@ToString(exclude = "courseMaterial")
public class Course {


    public Course() {

    }

    public Course(String title, Integer credit) {
        this.title = title;
        this.credit = credit;
    }
    public Course(String title, Integer credit, Teacher teacher) {
        this.title = title;
        this.credit = credit;
        this.teacher = teacher;
    }
    public Course(String title, Integer credit, Teacher teacher, CourseMaterial material) {
        this.title = title;
        this.credit = credit;
        this.teacher = teacher;
        this.courseMaterial = material;
    }

    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName =  "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator =  "course_sequence"
    )


    private Long courseId;
    private String title;
    private Integer credit;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
             optional = false
    )
    @JoinColumn(
            name = "course_material_id",
            referencedColumnName = "courseMaterialId"
    )

   private CourseMaterial courseMaterial;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id_ref",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;


}
