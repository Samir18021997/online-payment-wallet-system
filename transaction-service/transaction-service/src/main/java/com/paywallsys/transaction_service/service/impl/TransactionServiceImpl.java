package com.paywallsys.transaction_service.service.impl;

import com.paywallsys.transaction_service.dto.TransactionRequestDTO;
import com.paywallsys.transaction_service.dto.TransactionResponseDTO;
import com.paywallsys.transaction_service.model.Transaction;
import com.paywallsys.transaction_service.repository.TransactionRepository;
import com.paywallsys.transaction_service.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    @Override
    public TransactionResponseDTO createTransaction(TransactionRequestDTO transactionRequestDTO) {
        Transaction transaction = Transaction.builder()
                .walletId(transactionRequestDTO.walletId())
                .balance(transactionRequestDTO.balance())
                .type(transactionRequestDTO.type())
                .description(transactionRequestDTO.description())
                .build();
        transactionRepository.save(transaction);
        return mapToResponseDTO(transaction);
    }

    @Override
    public List<TransactionResponseDTO> getTransactionWalletId(Long walletId) {
        return transactionRepository.findByWalletId(walletId)
                .stream()
                .map(this:: mapToResponseDTO)
                .toList();
    }

    private TransactionResponseDTO mapToResponseDTO(Transaction transaction) {
        return new TransactionResponseDTO(transaction.getId(), transaction.getWalletId(), transaction.getBalance(), transaction.getType(), transaction.getDescription());
    }
}
