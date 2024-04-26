package dev.backend.demo.repositories;

import dev.backend.demo.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {
    /**
     * Enregistrer un client une fois selon son email
     * select * from client where email = emailEnter
     */
    ClientEntity findByEmail(String email);
}
