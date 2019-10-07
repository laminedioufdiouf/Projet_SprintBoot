package com.filerouge.ld.controller;

import com.filerouge.ld.model.Depot;
import com.filerouge.ld.repository.DepotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @CrossOrigin
    @RequestMapping(value = "/depot")
    public class DepotController {
        @Autowired
        private DepotRepository depotRepository;
        @GetMapping(value = "/liste")
        @PreAuthorize("hasAuthority('ROLE_ADMIN')")
        public List<Depot> liste()
        {return depotRepository.findAll();}
        @PostMapping(value = "/add",consumes = {MediaType.APPLICATION_JSON_VALUE})
        @PreAuthorize("hasAuthority('ROLE_ADMIN')")
        public  String add(@RequestBody(required = false) Depot d)
        {

            depotRepository.save(d);
            return "depot effectué";
        }


    }

