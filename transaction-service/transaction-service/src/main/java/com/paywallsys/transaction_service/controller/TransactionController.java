package com.paywallsys.transaction_service.controller;

import com.paywallsys.transaction_service.dto.TransactionRequestDTO;
import com.paywallsys.transaction_service.dto.TransactionResponseDTO;
import com.paywallsys.transaction_service.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping
    public TransactionResponseDTO createTransaction(@RequestBody TransactionRequestDTO transactionRequestDTO) {
        return transactionService.createTransaction(transactionRequestDTO);
    }

    @GetMapping("/wallet/{walletId}")
    public List<TransactionResponseDTO> getTransactionByWalletId(@PathVariable Long walletId) {
        return transactionService.getTransactionWalletId(walletId);
    }
}
