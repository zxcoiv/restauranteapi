package br.com.fiap.checkpointacpart02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tipo")
public class TipoController {
    @GetMapping
    public String tipo() {
        return "Americana, Italiana, Japonesa";
    }
}
