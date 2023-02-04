package com.example.focourseN.Entity;

import lombok.Data;


import javax.persistence.*;

@Entity
@Data
public class Teacher {


    public Teacher() {

    }

    public Teacher(String name, String rank) {
        this.teacherName = name;
        this.rank = rank;
    }

    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName =  "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator =  "teacher_sequence"
    )


    private Long teacherId;
    private String teacherName;
    private String rank;

    public Teacher(Long i, String emeka, String ordinary_staff) {
        this.teacherId = i;
        this.teacherName = emeka;
        this.rank = ordinary_staff;
    }
}
