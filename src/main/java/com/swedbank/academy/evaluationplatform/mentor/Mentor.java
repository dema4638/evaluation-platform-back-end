package com.swedbank.academy.evaluationplatform.mentor;

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
public class Mentor {

    @Id
    private long id;
    @Column(name = "name")
    @NotNull private String name;
    @Column(name = "stream")
    private Stream stream;

}