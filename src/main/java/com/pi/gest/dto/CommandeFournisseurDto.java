package com.pi.gest.dto;

import com.pi.gest.model.CommandeFournisseur;

import lombok.Builder;
import lombok.Data;


import java.time.Instant;
import java.util.List;

@Data
@Builder
public class CommandeFournisseurDto {

    private Integer id;
    private Integer idEntreprise;

    private String codeCmdFournisseur;
    private Instant dateCommande;


    private FournisseurDto fournisseur;


    private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs;

    public static CommandeFournisseurDto fromEntity(CommandeFournisseur commandeFournisseur){
        if(commandeFournisseur == null){
            return null;
        }

        return  CommandeFournisseurDto.builder()
                .id(commandeFournisseur.getId())
                .codeCmdFournisseur(commandeFournisseur.getCodeCmdFournisseur())
                .dateCommande(commandeFournisseur.getDateCommande())
                .idEntreprise(commandeFournisseur.getIdEntreprise())
                .build();
    }

    public static CommandeFournisseur toEntity(CommandeFournisseurDto commandeFournisseurDto){
        if(commandeFournisseurDto == null){
            return null;
        }
        CommandeFournisseur commandeFournisseur =  new CommandeFournisseur();
        commandeFournisseur.setId(commandeFournisseurDto.getId());
        commandeFournisseur.setCodeCmdFournisseur(commandeFournisseurDto.getCodeCmdFournisseur());
        commandeFournisseur.setDateCommande(commandeFournisseurDto.getDateCommande());
        commandeFournisseur.setFournisseur(FournisseurDto.toEntity(commandeFournisseurDto.getFournisseur()));
        commandeFournisseur.setIdEntreprise(commandeFournisseurDto.getIdEntreprise());


        return  commandeFournisseur;
    }


}
