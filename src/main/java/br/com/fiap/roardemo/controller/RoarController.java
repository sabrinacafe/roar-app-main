package br.com.fiap.roardemo.controller;

import br.com.fiap.roardemo.model.Roar;
import br.com.fiap.roardemo.service.RoarService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RoarController {

    private final RoarService service;

    public RoarController(RoarService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("roars", service.listAll());
        return "index";
    }

    @PostMapping("/roar")
    public String postRoar(@AuthenticationPrincipal OAuth2User principal, String content) {
        Roar roar = new Roar();
        roar.setUsername(principal.getAttribute("login"));
        roar.setAvatarUrl(principal.getAttribute("avatar_url"));
        roar.setContent(content);

        service.save(roar);
        return "redirect:/";
    }

    @PostMapping("/like/{id}")
    public String like(@PathVariable Long id) {
        service.like(id);
        return "redirect:/";
    }
}