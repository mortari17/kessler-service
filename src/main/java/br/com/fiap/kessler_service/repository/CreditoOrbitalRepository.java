package br.com.fiap.kessler_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.kessler_service.model.CreditoOrbital;

@Repository
public interface CreditoOrbitalRepository extends JpaRepository<CreditoOrbital, Long> {
}