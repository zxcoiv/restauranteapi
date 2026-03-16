package br.com.fiap.checkpointacpart02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("menu")
public class ComidaController {
    @GetMapping()
    public String menu() {
        return "Hamburger, Pizza, Sushi";
    }

    @GetMapping("/preco")
    public String preco() {
        return "R$50, R$70, R$65, R$35";
    }
}
