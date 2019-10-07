package com.filerouge.ld.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
@Entity
@Data
@EqualsAndHashCode(exclude = "partenaire")
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 15)
    private int numerocompte;
    @Column(length = 20)
    private int montant;
    @JoinColumn(name="partenaire_id", referencedColumnName = "id")
    @ManyToOne(optional = false)


    @JsonIgnoreProperties("compte")
    private Partenaire partenaire;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumerocompte() {
        return numerocompte;
    }

    public void setNumerocompte(int numerocompte) {
        this.numerocompte = numerocompte;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public Partenaire getPartenaire() {
        return partenaire;
    }

    public void setPartenaire(Partenaire partenaire) {
        this.partenaire = partenaire;
    }

}