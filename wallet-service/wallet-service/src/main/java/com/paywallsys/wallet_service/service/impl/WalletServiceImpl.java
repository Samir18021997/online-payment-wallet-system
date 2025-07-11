package com.paywallsys.wallet_service.service.impl;

import com.paywallsys.wallet_service.dto.WalletRequestDTO;
import com.paywallsys.wallet_service.dto.WalletResponseDTO;
import com.paywallsys.wallet_service.entity.Wallet;
import com.paywallsys.wallet_service.repository.WalletRepository;
import com.paywallsys.wallet_service.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;

    @Override
    public WalletResponseDTO createWallet(WalletRequestDTO walletRequestDTO) {

        Wallet wallet = Wallet.builder()
                .userId(walletRequestDTO.userId())
                .balance(walletRequestDTO.initialBalance())
                .build();
        walletRepository.save(wallet);

        return mapToResponse(wallet);
    }

    @Override
    public WalletResponseDTO getWalletByUserId(Long userId) {
        Wallet wallet = walletRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Wallet not found."));
        return mapToResponse(wallet);
    }

    @Override
    public WalletResponseDTO topUp(Long walletId, Double balance) {
        Wallet wallet = walletRepository.findByUserId(walletId)
                .orElseThrow(() -> new RuntimeException("Wallet not found."));
        wallet.setBalance(wallet.getBalance() + balance);
        walletRepository.save(wallet);
        return mapToResponse(wallet);
    }

    @Override
    public WalletResponseDTO deduct(Long walletId, Double balance) {
        Wallet wallet = walletRepository.findByUserId(walletId)
                .orElseThrow(() -> new RuntimeException("Wallet not found"));
        if(wallet.getBalance() < balance) {
            throw new RuntimeException("Insufficient Balance");
        }
        wallet.setBalance(wallet.getBalance() - balance);
        walletRepository.save(wallet);
        return mapToResponse(wallet);
    }

    private WalletResponseDTO mapToResponse(Wallet wallet) {
        return new WalletResponseDTO(wallet.getId(), wallet.getUserId(), wallet.getBalance());
    }
}
