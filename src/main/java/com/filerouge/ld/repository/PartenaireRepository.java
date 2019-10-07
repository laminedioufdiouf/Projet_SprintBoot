package com.filerouge.ld.repository;

import com.filerouge.ld.model.Depot;
import com.filerouge.ld.model.Partenaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartenaireRepository extends JpaRepository<Partenaire, Integer> {


}

