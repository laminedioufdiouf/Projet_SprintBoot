package com.filerouge.ld.model;

public class RegistrationUser {
    private String Username;
    private String name;
    private String password;
    private String telephone;
    private String status;
    private Long profil;
    private String email;
    private Partenaire partenaire;
    private  String ninea;
    private  String raisonsociale;
    private  String adress;
    private  String statut;
    // private Compte compte;
    private int compte_id;
    //private int partenaire_id;


    /* public int getPartenaire_id() {
         return partenaire_id;
     }

     public void setPartenaire_id(int partenaire_id) {
         this.partenaire_id = partenaire_id;
     }
 */
    public int getCompte_id() {
        return compte_id;
    }

    public void setCompte_id(int compte_id) {
        this.compte_id = compte_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getProfil() {
        return profil;
    }

    public void setProfil(Long profil) {
        this.profil = profil;
    }

    public Partenaire getPartenaire() {
        return partenaire;
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

    public void setPartenaire(Partenaire partenaire) {
        this.partenaire = partenaire;
    }
/*
    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }*/
}

