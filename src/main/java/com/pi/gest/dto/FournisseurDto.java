package com.pi.gest.dto;

import com.pi.gest.model.Fournisseur;
import lombok.Builder;
import lombok.Data;


import java.util.List;

@Data
@Builder
public class FournisseurDto {

    private Integer id;

    private String firstName;
    private String lastName;
    private String picFournisseur;
    private String emailFournisseur;
    private String numberFournisseur;

    private Integer idEntreprise;

    private AddressDto address;



    private List<CommandeFournisseurDto> commandeFournisseurs;


    public static FournisseurDto fromEntity(Fournisseur fournisseur){
        if(fournisseur == null){
            return (null);
        }

        return FournisseurDto.builder()
                .id(fournisseur.getId())
                .firstName(fournisseur.getFirstName())
                .lastName(fournisseur.getLastName())
                .address(AddressDto.fromEntity(fournisseur.getAddress()))
                .picFournisseur(fournisseur.getPicFournisseur())
                .emailFournisseur(fournisseur.getEmailFournisseur())
                .numberFournisseur(fournisseur.getNumberFournisseur())
                .build();


    }

    public static Fournisseur toEntity(FournisseurDto fournisseurDto) {

    if(fournisseurDto == null) {
        return null;
    }
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(fournisseurDto.getId());
        fournisseur.setFirstName(fournisseurDto.getFirstName());
        fournisseur.setLastName(fournisseurDto.getLastName());
        fournisseur.setEmailFournisseur(fournisseurDto.getEmailFournisseur());
        fournisseur.setNumberFournisseur(fournisseurDto.getNumberFournisseur());
        fournisseur.setPicFournisseur(fournisseurDto.getPicFournisseur());
        fournisseur.setAddress(fournisseur.getAddress());
        fournisseur.setIdEntreprise(fournisseurDto.getIdEntreprise());
        return fournisseur;
    }


}
