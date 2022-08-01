package com.bib.borrow.service;

import com.bib.borrow.domain.History;
import com.bib.borrow.repo.BorrowRepo;
import com.bib.borrow.repo.HistoryRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class HistoryServiceImpl implements HistoryService{
    private final HistoryRepo historyRepo;
    @Override
    public History saveHistoryB(History history,Integer book,Integer cin ) {
        log.info("Saving new Action to the database");

        history.setAction("Borrow");
        history.setCin(cin);
        history.setBook_id(book);
        SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return historyRepo.save(history);
    }

    public History saveHistoryR(History history,Integer book,Integer cin ) {
        log.info("Saving new Action to the database");

        history.setAction("Refuned");
        history.setCin(cin);
        history.setBook_id(book);
        SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return historyRepo.save(history);
    }

    @Override
    public List<History> getHistory() {
        log.info("Fetching all users");
        return historyRepo.findAll();
    }

}
