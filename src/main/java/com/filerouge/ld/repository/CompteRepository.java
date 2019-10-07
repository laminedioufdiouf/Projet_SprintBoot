package com.filerouge.ld.repository;

import com.filerouge.ld.model.Compte;
import com.filerouge.ld.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompteRepository extends JpaRepository<Compte, Integer> {
    Optional<Compte> findOneByNumerocompte(String numerocompte);
    Optional<Compte> findByNumerocompte(int numerocompte);
    Boolean existsByNumerocompte(String numerocompte);
    Optional<Compte> findOneById(Integer id);
}
