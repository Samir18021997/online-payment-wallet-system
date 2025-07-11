package com.paywallsys.transaction_service.dto;

public record TransactionRequestDTO(Long walletId, Double balance, String type, String description) {
}
