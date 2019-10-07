package com.filerouge.ld.controller;


import com.filerouge.ld.model.Compte;
import com.filerouge.ld.model.User;
import com.filerouge.ld.repository.CompteRepository;
import com.filerouge.ld.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/compte")
public class CompteController {

    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @Autowired
    private CompteRepository compteRepository;
    @GetMapping(value = "/liste")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Compte> liste()
    {return compteRepository.findAll();}
    @PostMapping(value = "/add")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String add( Compte c)

    {
        int x = (int)(Math.random()*((999999)+10));
        c.setNumerocompte(x);
        User user= userDetailsService.getUserconnect();
        user.getPartenaire();
        c.setPartenaire(user.getPartenaire());
        c.setMontant(0);
        compteRepository.save(c);
        return "compte creer avec succee!!!";
    }


}
