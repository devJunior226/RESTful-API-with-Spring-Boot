package dev.backend.demo.controllers;

import dev.backend.demo.entities.SentimentEntity;
import dev.backend.demo.enums.TypeSentiment;
import dev.backend.demo.services.SentimentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "sentiment", produces = APPLICATION_JSON_VALUE)
public class SentimentController {
    private SentimentService sentimentService;

    public SentimentController(SentimentService sentimentService) {
        this.sentimentService = sentimentService;
    }

    // Post d'un sentiment
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void postSentiment(@RequestBody SentimentEntity sentiment) {
        this.sentimentService.createSentiment(sentiment);
    }

    /**
     * Pouvoir rechercher un sentiment selon son type
     *
     */
    @GetMapping
    public @ResponseBody List<SentimentEntity> getListSentiments(TypeSentiment type) {
        return this.sentimentService.listSentiments(type);
    }

    // Get listeSentiments
//    @GetMapping
//    public @ResponseBody List<SentimentEntity> getListSentiments() {
//        return this.sentimentService.listSentiments();
//    }

    // Supprimer un sentiment
    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping(path = "{sentimentId}")
    public void deleteSentiment(@PathVariable int sentimentId) {
        this.sentimentService.removeSentiment(sentimentId);
    }
}















