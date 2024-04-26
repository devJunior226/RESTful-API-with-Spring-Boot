package dev.backend.demo.repositories;

import dev.backend.demo.entities.SentimentEntity;
import dev.backend.demo.enums.TypeSentiment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SentimentRepository extends JpaRepository<SentimentEntity, Integer> {
    /**
     * Methode de recherche en fonction du type entré
     * Ce sera une liste de sentiments
     * Ce qui correspond a
     * SELECT * FROM sentiment
     * WHERE type = type
     */
    List<SentimentEntity> findByType(TypeSentiment type);
}
