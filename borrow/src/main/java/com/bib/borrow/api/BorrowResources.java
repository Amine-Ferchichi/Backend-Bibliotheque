package com.bib.borrow.api;

import com.bib.borrow.CompositeKey;
import com.bib.borrow.domain.Borrow;
import com.bib.borrow.domain.History;
import com.bib.borrow.repo.HistoryRepo;
import com.bib.borrow.service.BorrowService;
import com.bib.borrow.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.awt.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BorrowResources {

    public  final BorrowService borrowService;
public final HistoryService historyService;
public  final HistoryRepo historyRepo;

    @GetMapping("/History")
    public ResponseEntity<List<History>>getHistory(){

        return ResponseEntity.ok().body(historyService.getHistory());
    }
    @PostMapping("/Borrow")
    public ResponseEntity<Borrow> saveBorrow(@RequestBody Borrow borrow){
        URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/Borrow").toUriString());


            History history = new History();
            historyService.saveHistoryB(history, borrow.getBook_id(), borrow.getCin());

        return ResponseEntity.created(uri).body(borrowService.saveBorrow(borrow));
    }
    @DeleteMapping("/Refund")
    public ResponseEntity<?> saveRefund(@RequestBody Borrow borrow){
        URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/Refund").toUriString());
        CompositeKey id = new CompositeKey();
       id.setBook_id(borrow.getBook_id());
       id.setCin(borrow.getCin());

        History history = new History();
        historyService.saveHistoryR(history, borrow.getBook_id(), borrow.getCin());
borrowService.SaveRefund(id);
        return ResponseEntity.ok().build();
    }







}
