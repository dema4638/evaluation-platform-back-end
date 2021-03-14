package com.swedbank.academy.evaluationplatform.student;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
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
