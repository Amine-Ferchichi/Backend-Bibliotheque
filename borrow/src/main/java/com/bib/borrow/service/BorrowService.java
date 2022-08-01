package com.bib.borrow.service;

import com.bib.borrow.CompositeKey;
import com.bib.borrow.domain.Borrow;

public interface BorrowService {
Borrow saveBorrow(Borrow borrow);
    public void  SaveRefund(CompositeKey id);
}
