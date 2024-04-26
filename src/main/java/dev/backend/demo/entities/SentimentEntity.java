package dev.backend.demo.entities;

import dev.backend.demo.enums.TypeSentiment;
import jakarta.persistence.*;

@Entity
@Table(name = "sentiment")
public class SentimentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indique que c'est la bd qui genere les pk
    private int id;
    private String texte;
    private TypeSentiment type;

    /**
     * Liaison entre les deux entites
     * Un client peut deposer 1 ou n sentiments
     * C'est donc du ManyToOne
     * Pour faire en sorte qu'on puisse enregistrer a la fois le client et son sentiment
     * Methode en cascade
     * PERSIST => Enregistre le client, recupere sa pk et injecte-la dans la fk de sentiment
     * Merge => Si client existe deja, ne plus le creer
     */
    @ManyToOne
    @JoinColumn(name = "clientId") // Indique le champ qui constitue la relation
    private ClientEntity client;

    public SentimentEntity() {
    }

    public SentimentEntity(int id, String texte, TypeSentiment type, ClientEntity client) {
        this.id = id;
        this.texte = texte;
        this.type = type;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public TypeSentiment getType() {
        return type;
    }

    public void setType(TypeSentiment type) {
        this.type = type;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }
}
