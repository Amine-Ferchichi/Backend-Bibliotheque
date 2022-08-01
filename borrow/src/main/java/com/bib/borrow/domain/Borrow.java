package com.bib.borrow.domain;


import com.bib.borrow.CompositeKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(CompositeKey.class)
public class Borrow {
    @Id
    private Integer book_id;
    @Id
    private Integer cin;
}
