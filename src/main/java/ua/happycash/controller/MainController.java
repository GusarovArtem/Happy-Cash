package ua.happycash.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.happycash.database.repository.UserRepository;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {

    private final UserRepository userRepository;

    @GetMapping()
    public String index() {

        return "";
    }
}
