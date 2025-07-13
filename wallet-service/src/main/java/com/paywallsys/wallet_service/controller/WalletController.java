package com.paywallsys.wallet_service.controller;

import com.paywallsys.wallet_service.dto.WalletRequestDTO;
import com.paywallsys.wallet_service.dto.WalletResponseDTO;
import com.paywallsys.wallet_service.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallets")
@RequiredArgsConstructor
public class WalletController {

    private final WalletService walletService;

    @PostMapping
    public WalletResponseDTO createWallet(@RequestBody WalletRequestDTO walletRequestDTO) {
        return walletService.createWallet(walletRequestDTO);
    }

    @GetMapping("/user/{userId}")
    public WalletResponseDTO getWalletByUserId(@PathVariable Long userId) {
        return walletService.getWalletByUserId(userId);
    }

    @PostMapping("/{walletId}/topup")
    public WalletResponseDTO topUp(@PathVariable Long walletId, @RequestParam Double balance) {
        return walletService.topUp(walletId, balance);
    }

    @PostMapping("/{walletId}/deduct")
    public WalletResponseDTO deduct(@PathVariable Long walletId, @RequestParam Double balance) {
        return walletService.deduct(walletId, balance);
    }
}
