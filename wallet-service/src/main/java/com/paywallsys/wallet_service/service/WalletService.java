package com.paywallsys.wallet_service.service;

import com.paywallsys.wallet_service.dto.WalletRequestDTO;
import com.paywallsys.wallet_service.dto.WalletResponseDTO;

public interface WalletService {
    WalletResponseDTO createWallet(WalletRequestDTO walletRequestDTO);
    WalletResponseDTO getWalletByUserId(Long userId);
    WalletResponseDTO topUp(Long walletId, Double balance);
    WalletResponseDTO deduct(Long walletId, Double balance);
}
