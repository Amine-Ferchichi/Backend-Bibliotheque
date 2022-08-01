package com.bib.borrow.service;

import com.bib.borrow.domain.History;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HistoryService {

    History saveHistoryB(History history,Integer book,Integer cin);
    History saveHistoryR(History history,Integer book,Integer cin);
    List<History> getHistory();




}
