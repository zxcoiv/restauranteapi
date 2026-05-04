package br.com.fiap.checkpointacpart02.controller;

import br.com.fiap.checkpointacpart02.model.Comida;
import br.com.fiap.checkpointacpart02.repository.ComidaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("menu")
public class ComidaController {
    private ComidaRepository repository;

    public ComidaController(ComidaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Comida> create(@RequestBody Comida comida) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(comida));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comida> findById(@PathVariable Long id) {
        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Comida>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comida> update(@PathVariable Long id, @RequestBody Comida comida) {
        Optional<Comida> optComida = repository.findById(id);

        if (optComida.isPresent()) {
            comida.setId(id);
            Comida comidaAlterado = repository.save(comida);
            return ResponseEntity.ok(comidaAlterado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
