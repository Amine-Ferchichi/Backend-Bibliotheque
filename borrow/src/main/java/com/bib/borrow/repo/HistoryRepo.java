package com.bib.borrow.repo;

import com.bib.borrow.domain.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HistoryRepo extends JpaRepository<History,Integer> {


}
