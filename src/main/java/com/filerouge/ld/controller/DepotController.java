package com.filerouge.ld.controller;

import com.filerouge.ld.model.Compte;
import com.filerouge.ld.model.Depot;
import com.filerouge.ld.model.DepotForm;
import com.filerouge.ld.repository.CompteRepository;
import com.filerouge.ld.repository.DepotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import java.util.Date;
import java.util.List;

    @RestController
    @CrossOrigin
    @RequestMapping(value = "/depot")
    public class DepotController {
        @Autowired
        private DepotRepository depotRepository;
        @Autowired
        private CompteRepository compteRepository;
        @GetMapping(value = "/liste")
        @PreAuthorize("hasAuthority('ROLE_ADMIN')")
        public List<Depot> liste()
        {return depotRepository.findAll();}
        @PostMapping(value = "/add",consumes = {MediaType.APPLICATION_JSON_VALUE})
        @PreAuthorize("hasAuthority('ROLE_ADMIN')")
        public  String add(@RequestBody DepotForm depotForm)
        {
        Depot depot = new Depot();
            depot.setSolde( depotForm.getMontant());
            depot.setDatedepot(new Date());
            Compte cpt = compteRepository.findByNumerocompte(depotForm.getNumerocompte()).orElseThrow(()-> new EntityExistsException("erreur de choix de compte"));
            depot.setCompte(cpt);

            depotRepository.save(depot);
            return "depot effectué";
        }


    }

