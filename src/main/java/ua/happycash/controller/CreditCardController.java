package ua.happycash.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.happycash.service.creaditCard.CreditCardServiceImpl;

@RestController
@RequestMapping("/credit-card")
@RequiredArgsConstructor
public class CreditCardController {

    private final CreditCardServiceImpl creditCardService;

    //  TODO logic for credit card mappings
}
