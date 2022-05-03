package com.pi.gest.dto;


import com.pi.gest.model.CommandeClient;
import lombok.Builder;
import lombok.Data;


import java.time.Instant;
import java.util.List;


@Data
@Builder
public class CommandeClientDto {

    private Integer id;

    private String codeCommandeClient;
    private Instant dateCommandeClient;
    private Integer idEntreprise;


    private ClientDto client;


    private List<LigneCommandeClientDto> ligneCommandeClients;



    public  static CommandeClientDto fromEntity(CommandeClient commandeClient){
        if(commandeClient == null){
            return null;
        }
        return CommandeClientDto.builder()
                .id(commandeClient.getId())
                .codeCommandeClient(commandeClient.getCodeCommandeClient())
                .dateCommandeClient(commandeClient.getDateCommandeClient())
                .idEntreprise(commandeClient.getIdEntreprise())
                .client(ClientDto.fromEntity(commandeClient.getClient()))
                .build();
    }
    public static CommandeClient toEntity(CommandeClientDto commandeClientDto){
        if(commandeClientDto == null)
        {return null;}


        CommandeClient commandeClient =  new CommandeClient();
        commandeClient.setId(commandeClientDto.getId());
        commandeClient.setCodeCommandeClient(commandeClientDto.getCodeCommandeClient());
        commandeClient.setDateCommandeClient(commandeClientDto.getDateCommandeClient());
        commandeClient.setIdEntreprise(commandeClientDto.getIdEntreprise());
        commandeClient.setClient(ClientDto.toEntity(commandeClientDto.getClient()));

    return commandeClient;
    }
}
