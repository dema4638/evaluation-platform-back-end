package com.swedbank.academy.evaluationplatform.lecturer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lecturer {

    @Id
    private long id;
    @Column(name = "name")
    @NotNull private String name;
    @Column(name= "email")
    private String email;
    @Column(name = "area")
    private Area area;

}