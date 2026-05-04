package br.com.fiap.checkpointacpart02.repository;

import br.com.fiap.checkpointacpart02.model.Comida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComidaRepository extends JpaRepository<Comida, Long> {
}
