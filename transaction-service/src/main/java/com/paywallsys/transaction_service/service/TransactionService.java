package com.paywallsys.transaction_service.service;

import com.paywallsys.transaction_service.dto.TransactionRequestDTO;
import com.paywallsys.transaction_service.dto.TransactionResponseDTO;

import java.util.List;

public interface TransactionService {
    TransactionResponseDTO createTransaction(TransactionRequestDTO transactionRequestDTO);
    List<TransactionResponseDTO> getTransactionWalletId(Long walletId);
}
