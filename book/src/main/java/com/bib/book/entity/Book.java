package com.bib.book.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
   @Id
    @GeneratedValue(strategy = AUTO)
    private Integer bookId;
    private String bookName;
    private Integer nbTEmprunt;
    private Integer nbExemplaire;
}
