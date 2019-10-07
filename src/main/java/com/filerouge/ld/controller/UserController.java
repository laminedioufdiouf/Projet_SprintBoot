package com.filerouge.ld.controller;

import com.filerouge.ld.model.*;
import com.filerouge.ld.repository.CompteRepository;
import com.filerouge.ld.repository.PartenaireRepository;
import com.filerouge.ld.repository.UserRepository;
import com.filerouge.ld.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.beans.Encoder;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    PartenaireRepository partenaireRepository;
    @Autowired
    CompteRepository compteRepository;
    @Autowired
    UserRepository userRepository;
    @GetMapping(value = "/liste")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<User> liste()
    {
        return userRepository.findAll();
    }

    @PostMapping(value = "/add",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String add(@RequestBody(required = false) RegistrationUser registrationUser)
    {
        User u =new User();
        u.setName(registrationUser.getName());
        u.setUsername(registrationUser.getUsername());
        u.setPassword(encoder.encode(registrationUser.getPassword()));
        u.setTelephone(registrationUser.getTelephone());
        u.setEmail(registrationUser.getEmail());
        u.setStatus(registrationUser.getStatus());

        Set<Role> roles = new HashSet<>();
        Role role= new Role();
        role.setId(registrationUser.getProfil());
        roles.add(role);
        u.setRoles(roles);

        User user= userDetailsService.getUserconnect();
        user.getPartenaire();

        Partenaire part=new Partenaire();
        part.setNinea(registrationUser.getNinea());
        part.setAdress(registrationUser.getAdress());
        part.setStatut(registrationUser.getStatut());
        part.setRaisonsociale(registrationUser.getRaisonsociale());
        u.setPartenaire(part);
        partenaireRepository.save(part);

        // p.setId(registrationUser.getPartenaire_id());
        //u.setPartenaire(p);
        int x = (int)(Math.random()*((999999)+10));
        Compte c =new Compte();
        c.setId(registrationUser.getCompte_id());
        c.setNumerocompte(x);
        c.setMontant(0);
        c.setPartenaire(part);
        compteRepository.save(c);
        u.setCompte(c);
        userRepository.save(u);
        return "User ajoutée!!!";

    }

    @GetMapping(value = "/edit/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String update(@PathVariable("id") Long id)
    {
        User user=userRepository.findById(id).orElseThrow(()->new IllegalArgumentException("invalid user id:"+id));
        if (user.getUsername().equals("mbacke"))
        {
            return "le super_admin ne peut pas etre bloqué";
        }
        if(user.getStatus().equals("active"))
        {
            user.setStatus("desactive");
        }
        else if(user.getStatus().equals("desactive"))
        {
            user.setStatus("active");
        }
        userRepository.saveAndFlush(user);
        return "update user";

    }
}