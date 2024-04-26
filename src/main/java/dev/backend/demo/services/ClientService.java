package dev.backend.demo.services;

import dev.backend.demo.entities.ClientEntity;
import dev.backend.demo.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    // Enregistrement d'un client
    public void createClient(ClientEntity client) {
        ClientEntity clientInDB = this.clientRepository.findByEmail(client.getEmail());
        if (clientInDB == null) {
            this.clientRepository.save(client);
        }
    }

    // Retourner la liste des clients: C'est une liste
    public List<ClientEntity> listeClients() {
        return this.clientRepository.findAll();
    }

    // Retourner un client selon son id
    public ClientEntity detailsClient(int id) {
        Optional<ClientEntity> optionalClient = this.clientRepository.findById(id);
//        if (optionalClient.isPresent()) {
//            return optionalClient.get();
//        }
//        return null;
        /// refactoring
        return optionalClient.orElse(null);
    }

    /**
     * On verifie s'il y'a deja un client.
     * S'il n'en existe pas, on en cree. Sinon, on le retourne seulement
     */
    public ClientEntity lireOuCreer(ClientEntity clientAcreer) {
        ClientEntity clientInDB = this.clientRepository.findByEmail(clientAcreer.getEmail());
        if (clientInDB == null) {
            clientInDB = this.clientRepository.save(clientAcreer);
        }
        return clientInDB;
    }

    /**
     * Modification d'un client
     * D'abord recuperer le client qui est dans la BD
     * Et là, la methode detailsClient() le fait deja
     * @param id
     * @param client
     */
    public void editClient(int id, ClientEntity client) {
        ClientEntity clientAmodifier = this.detailsClient(id);
        if (clientAmodifier.getId() == client.getId()) {
            clientAmodifier.setEmail(client.getEmail());
            clientAmodifier.setTelephone(client.getTelephone());
            this.clientRepository.save(clientAmodifier);
        }
    }
}
