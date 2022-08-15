package ua.happycash.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.happycash.service.wallet.WalletServiceImpl;

@RestController
@RequestMapping("/wallet")
@RequiredArgsConstructor
public class WalletController {

    private final WalletServiceImpl walletService;

    //  TODO logic for wallet mappings
}
