package com.filerouge.ld.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;
import java.util.Date;

@Entity
@CrossOrigin
@RequestMapping(value = "/depot")

public class Depot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 20)
    private int solde;
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date datedepot;
    @JoinColumn(name="compte_id",referencedColumnName = "id")
    // private Compte compte;



    // private User user;
    @ManyToOne(optional = false)
    //@JoinTable(name="depot",joinColumns = @JoinColumn(name = "compte_id"),
     //inverseJoinColumns = @JoinColumn(name="user_id"))
    @JsonIgnoreProperties("depot")
    private Compte compte;
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("depot")

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public Date getDatedepot() {
        return datedepot;
    }

    public void setDatedepot(Date datedepot) {
        this.datedepot = datedepot;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

  /*  public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/
}