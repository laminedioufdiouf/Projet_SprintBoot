package com.filerouge.ld.controller;

import com.filerouge.ld.model.Partenaire;
import com.filerouge.ld.repository.PartenaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/partenaire")
public class PartenaireController {
    @Autowired
    private PartenaireRepository partenaireRepository;
    @GetMapping(value = "/liste")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Partenaire> liste(){
        return partenaireRepository.findAll();
    }

    //ajout partenaire dans la base de données
    @PostMapping(value = "/add",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Partenaire add(@RequestBody(required = false) Partenaire part){
        return partenaireRepository.save(part);
    }

}
