package dev.backend.demo.services;

import dev.backend.demo.controllers.SentimentController;
import dev.backend.demo.entities.ClientEntity;
import dev.backend.demo.entities.SentimentEntity;
import dev.backend.demo.enums.TypeSentiment;
import dev.backend.demo.repositories.SentimentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SentimentService {
    private SentimentRepository sentimentRepository;
    private ClientService clientService;

    public SentimentService(SentimentRepository sentimentRepository, ClientService clientService) {
        this.sentimentRepository = sentimentRepository;
        this.clientService = clientService;
    }

    /**
     * Avant de creer le client, on verifie s'il existe deja
     * Pour cela, injecter le client service
     * Le nouveau client a utiliser es celui de la bd
     */

    /**
     * Pour prendre en compte le sentiment, on pourrait dire que:
     * Si dans l'appreciation du client, il y'a la negation "pas", alors on attribue le type NEGATIF
     * Sinon, c'est un sentiment positif
     * @param sentiment
     */

    public void createSentiment(SentimentEntity sentiment) {
        ClientEntity client = this.clientService.lireOuCreer(sentiment.getClient());
        sentiment.setClient(client);

        if (sentiment.getTexte().contains("pas")) {
            sentiment.setType(TypeSentiment.NEGATIF);
        } else {
            sentiment.setType(TypeSentiment.POSITIF);
        }
        this.sentimentRepository.save(sentiment);
    }

    /**
     * Pouvoir rechercher un sentiment selon son type
     * Si rien n'est renseigné dans l'URL, on retourne tout
     * Sinon, on retourne seulement les sentiments dont le type a été renseigné
     */
    public List<SentimentEntity> listSentiments(TypeSentiment type) {
        if (type == null) {
            return this.sentimentRepository.findAll();
        } else {
            return this.sentimentRepository.findByType(type);
        }
    }

//    public List<SentimentEntity> listSentiments() {
//        return this.sentimentRepository.findAll();
//    }

    // Supprimer un sentiment
    public void removeSentiment(int sentimentId) {
        this.sentimentRepository.deleteById(sentimentId);
    }

    // Editer un sentiment
//    public void editSentiment(int id, SentimentEntity sentiment) {
//
//    }
}
