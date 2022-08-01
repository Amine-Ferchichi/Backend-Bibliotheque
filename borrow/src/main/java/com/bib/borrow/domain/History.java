package com.bib.borrow.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class History {
    @Id @GeneratedValue(strategy = AUTO)
    private Integer id;

    private Integer book_id;

    private Integer cin;

    @Temporal(TemporalType.TIMESTAMP)
    Date creationDateTime;

    //B: borrowed R:refunded
    private String Action;


}
