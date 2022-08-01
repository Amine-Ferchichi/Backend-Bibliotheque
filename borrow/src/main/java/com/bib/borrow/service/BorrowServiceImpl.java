package com.bib.borrow.service;

import com.bib.borrow.CompositeKey;
import com.bib.borrow.domain.Borrow;
import com.bib.borrow.repo.BorrowRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class BorrowServiceImpl implements BorrowService{

private final BorrowRepo borrowRepo;

    @Override
    public Borrow saveBorrow(Borrow borrow) {
        log.info("Saving new Borrow {} {} to the database",borrow.getBook_id(),borrow.getCin());

        return borrowRepo.save(borrow);
    }

    @Override
    public void SaveRefund(CompositeKey id) {
borrowRepo.deleteById(id);
    }

}
