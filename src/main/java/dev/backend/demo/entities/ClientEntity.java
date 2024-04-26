package dev.backend.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "client")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String email;
    private String telephone;

    // constructors
    public ClientEntity() {}

    public ClientEntity(int id, String email, String telephone) {
        this.id = id;
        this.email = email;
        this.telephone = telephone;
    }

    // Getters pour lire les donnees
    // and Setters pour definir les donnees
    public int getId() {
        return id;
    }

    public void setId(int clientId) {
        this.id = clientId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String clientEmail) {
        this.email = clientEmail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}