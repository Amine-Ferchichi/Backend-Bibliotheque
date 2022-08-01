package com.bib.borrow.repo;
import com.bib.borrow.CompositeKey;
import com.bib.borrow.domain.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BorrowRepo extends JpaRepository<Borrow, CompositeKey> {
}
