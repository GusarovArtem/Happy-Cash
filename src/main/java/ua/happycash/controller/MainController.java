package ua.happycash.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.happycash.database.entity.user.User;
import ua.happycash.database.entity.wallet.Wallet;
import ua.happycash.dto.user.UserReadDto;
import ua.happycash.service.user.UserServiceImpl;
import ua.happycash.service.wallet.WalletServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class MainController {

    @NonFinal
    @Value("${spring.profiles.active:prod}")
    String profile;

    UserServiceImpl userService;
    WalletServiceImpl walletService;

    @GetMapping
    @Transactional
    public String index(
            @AuthenticationPrincipal User user,
            Model model
    ) {
        Map<Object, Object> data = new HashMap<>();

        if (user != null) {
            UserReadDto userEntity = userService.getHoder(user.getName());
            data.put("profile", userEntity);
            List<Wallet> messages = walletService.findAllForUser(oauthUser.getUser());
            data.put("profile", userEntity);
            data.put("messages", messages);
        }
        model.addAttribute("frontendData", data);
        model.addAttribute("isDevMode", "dev".equals(profile));

        return "index";
    }
}
