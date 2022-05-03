package com.pi.gest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pi.gest.model.Client;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class ClientDto {

    private Integer id;

    private String firstName;
    private String lastName;
    private String picClient;
    private String emailClient;
    private String numberClient;
    private Integer idEntreprise;


    private AddressDto address;

    @JsonIgnore
    private List<CommandeClientDto> commandeClients;


    public static ClientDto fromEntity(Client client) {
        if (client == null) {
            return null;
        }
        return ClientDto.builder()
                .id(client.getId())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .address(AddressDto.fromEntity(client.getAddress()))
                .picClient(client.getPicClient())
                .numberClient(client.getNumberClient())
                .emailClient(client.getEmailClient())
                .idEntreprise(client.getIdEntreprise())
                .build();
    }





    public static Client toEntity(ClientDto clientDto) {
        if (clientDto == null) {
            return null;
        }
        Client client = new Client();
        client.setId(clientDto.getId());
        client.setFirstName(client.getFirstName());
        client.setLastName(client.getLastName());
        client.setPicClient(client.getPicClient());
        client.setEmailClient(client.getEmailClient());
        client.setNumberClient(client.getNumberClient());
        client.setIdEntreprise(client.getIdEntreprise());
        client.setIdEntreprise(client.getIdEntreprise());

        return client;
    }
}
