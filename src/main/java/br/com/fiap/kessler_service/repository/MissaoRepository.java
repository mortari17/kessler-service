package br.com.fiap.kessler_service.repository;

import br.com.fiap.kessler_service.entity.Missao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissaoRepository extends JpaRepository<Missao, Long> {
}