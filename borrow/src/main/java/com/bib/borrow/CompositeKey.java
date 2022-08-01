package com.bib.borrow;

import java.io.Serializable;
import java.math.BigInteger;

public class CompositeKey implements Serializable {
    private Integer book_id;
    private Integer cin;


    public Integer getbook() {
        return book_id;
    }
    public Integer getCin() {
        return cin;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }
    public void setCin(Integer cin) {
        this.cin = cin;
    }
}
