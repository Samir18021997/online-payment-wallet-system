package com.paywallsys.transaction_service.dto;

public record TransactionResponseDTO(Long id, Long walletId, Double balance, String type, String description) {
}
