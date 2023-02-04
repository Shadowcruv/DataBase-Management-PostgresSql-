package com.example.focourseN.Entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Data
//@ToString(exclude = "course")
public class CourseMaterial {


    public CourseMaterial() {
    }

    public CourseMaterial(String url, Course course) {
        this.url = url;
        this.course = course;
    }

    public CourseMaterial(String url) {
        this.url = url;
    }

    @Id
    @SequenceGenerator(
            name = "courseMaterial_sequence",
            sequenceName =  "courseMaterial_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator =  "courseMaterial_sequence"
    )

    private Long courseMaterialId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL,
            mappedBy = "courseMaterial"

    )
    private Course course;



}
