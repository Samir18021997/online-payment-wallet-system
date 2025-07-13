package com.paywallsys.transaction_service.controller;

import com.paywallsys.transaction_service.TransactionEventPublisher;
import com.paywallsys.transaction_service.dto.TransactionRequestDTO;
import com.paywallsys.transaction_service.dto.TransactionResponseDTO;
import com.paywallsys.transaction_service.model.Transaction;
import com.paywallsys.transaction_service.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @Autowired
    private TransactionEventPublisher publisher;

    @PostMapping("/transactions")
    public ResponseEntity<String> crateTransaction(@RequestBody Transaction transaction) {
        publisher.publish("Transaction created: ID= " + transaction.getId());
        return ResponseEntity.ok("Transaction Created!");
    }

    @PostMapping
    public TransactionResponseDTO createTransaction(@RequestBody TransactionRequestDTO transactionRequestDTO) {
        return transactionService.createTransaction(transactionRequestDTO);
    }

    @GetMapping("/wallet/{walletId}")
    public List<TransactionResponseDTO> getTransactionByWalletId(@PathVariable Long walletId) {
        return transactionService.getTransactionWalletId(walletId);
    }
}
