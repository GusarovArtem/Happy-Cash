package ua.happycash.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.happycash.service.transaction.TransactionServiceImpl;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionServiceImpl transactionService;

    //  TODO logic for transaction mappings
}
