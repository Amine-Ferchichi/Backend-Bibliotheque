package com.bib.student.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
@Id
private Integer cin;
    private String studentFirstName;
    private String studentLastName;
    private String studentPhone;
    private String studentMail;
}
