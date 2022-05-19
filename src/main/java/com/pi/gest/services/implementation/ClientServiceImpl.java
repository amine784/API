package com.pi.gest.services.implementation;

import com.pi.gest.dto.ClientDto;
import com.pi.gest.exception.EntityNotFoundException;
import com.pi.gest.exception.Errors;
import com.pi.gest.exception.InvalidEntityException;
import com.pi.gest.exception.InvalidOperationException;
import com.pi.gest.model.CommandeClient;
import com.pi.gest.repository.ClientRepository;
import com.pi.gest.repository.CommandeClientRepository;
import com.pi.gest.services.ClientService;
import com.pi.gest.validator.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class ClientServiceImpl implements ClientService {



    private ClientRepository clientRepository;
    private CommandeClientRepository commandeClientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, CommandeClientRepository commandeClientRepository) {
        this.clientRepository = clientRepository;
        this.commandeClientRepository = commandeClientRepository;
    }

    @Override
    public ClientDto save(ClientDto dto) {
        List<String> errors = ClientValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Le Client n'est pas  valide {}", dto);
            throw new InvalidEntityException("Le client n'est pas valide", Errors.CLIENT_NOT_VALID, errors);
    }
        return ClientDto.fromEntity(clientRepository.save(ClientDto.toEntity(dto)));
    }

    @Override
    public ClientDto findById(Integer id) {
        if (id == null) {
            log.error("Client ID is null");
            return null;
        }
        return clientRepository.findById(id)
                .map(ClientDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Aucun Client avec l'ID = " + id + " n' ete trouve dans la BDD", Errors.CLIENT_NOT_FOUND));
    }

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream().map(ClientDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {

        if (id == null) {
            log.error("Client ID is null");
            return;
        }
        List<CommandeClient> commandeClients = commandeClientRepository.findAllByClientId(id);
        if (!commandeClients.isEmpty()) {
            throw new InvalidOperationException("Impossible de supprimer un client qui a deja des commande clients",
                    Errors.CLIENT_ALREADY_IN_USE);
        }
        clientRepository.deleteById(id);
    }
}
