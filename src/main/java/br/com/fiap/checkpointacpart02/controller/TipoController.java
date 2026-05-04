package br.com.fiap.checkpointacpart02.controller;

import br.com.fiap.checkpointacpart02.model.Tipo;
import br.com.fiap.checkpointacpart02.repository.TipoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("tipo")
public class TipoController {
    private TipoRepository repository;

    public TipoController(TipoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Tipo> create(@RequestBody Tipo tipo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tipo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tipo> findById(@PathVariable Long id) {
        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Tipo>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tipo> update(@PathVariable Long id, @RequestBody Tipo tipo) {
        Optional<Tipo> optTipo = repository.findById(id);

        if (optTipo.isPresent()) {
            tipo.setId(id);
            Tipo tipoAlterado = repository.save(tipo);
            return ResponseEntity.ok(tipoAlterado);
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
