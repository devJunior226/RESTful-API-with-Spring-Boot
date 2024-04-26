package dev.backend.demo.controllers;

import dev.backend.demo.entities.ClientEntity;
import dev.backend.demo.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "client")

public class ClientController {
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    // Enregistrement d'un client
    @ResponseStatus(value = HttpStatus.CREATED)
    // Il n'y a que le postmapping qui a un body,
    // d'ou l'emplacement APPLICATION_JSON_VALUE ici

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void postClient(@RequestBody ClientEntity client) {

        this.clientService.createClient(client);
    }

// ***********************
    // Retourner la liste des clients
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<ClientEntity> getAllClients() {
        return this.clientService.listeClients();
    }

    // Lire un client
    @GetMapping(path = "{id}", produces = APPLICATION_JSON_VALUE)
    public ClientEntity getClient(@PathVariable int id) {
        return this.clientService.detailsClient(id);
    }

    // Mise a jour d'un client
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @PutMapping(path = "{id}", consumes = APPLICATION_JSON_VALUE)
    public void putClient(@PathVariable int id, @RequestBody ClientEntity client) {
        this.clientService.editClient(id, client);
    }
}











