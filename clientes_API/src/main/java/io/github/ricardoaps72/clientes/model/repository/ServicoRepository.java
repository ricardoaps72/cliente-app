package io.github.ricardoaps72.clientes.model.repository;

import io.github.ricardoaps72.clientes.model.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}
