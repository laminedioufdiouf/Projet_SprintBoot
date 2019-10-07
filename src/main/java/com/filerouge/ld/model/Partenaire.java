package com.filerouge.ld.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@CrossOrigin
@RequestMapping("/partenaire")
//@EqualsAndHashCode(exclude = "depot")
public class Partenaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50)
    private String ninea;
    @Column(length = 50)
    private String raisonsociale;
    @Column(length = 50)
    private String adress;
    @Column(length = 50)
    private String statut;
    @OneToMany(mappedBy = "partenaire")
    @JoinColumn(name = "compte_id", referencedColumnName = "id")
     @ManyToOne(optional = false)
    @JsonIgnoreProperties("partenaire")
    //@JsonManagedReference
    //private Compte compte;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNinea() {
        return ninea;
    }

    public void setNinea(String ninea) {
        this.ninea = ninea;
    }

    public String getRaisonsociale() {
        return raisonsociale;
    }

    public void setRaisonsociale(String raisonsociale) {
        this.raisonsociale = raisonsociale;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
}