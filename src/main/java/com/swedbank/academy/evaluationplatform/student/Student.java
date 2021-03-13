package com.swedbank.academy.evaluationplatform.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Student {

    @Id
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;


    public Student() {
    }
}
