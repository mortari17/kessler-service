package br.com.fiap.kessler_service.repository;

import br.com.fiap.kessler_service.entity.CreditoOrbital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditoOrbitalRepository extends JpaRepository<CreditoOrbital, Long> {
}