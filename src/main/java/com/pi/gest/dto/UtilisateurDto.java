package com.pi.gest.dto;

import com.pi.gest.model.Utilisateur;
import lombok.Builder;
import lombok.Data;


import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class UtilisateurDto {

    private Integer id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String imageUser;

    private EntrepriseDto entreprise;
    private AddressDto adresse;


    private List<RoleDto> role ;


    public static UtilisateurDto fromEntity(Utilisateur utilisateur){
        if(utilisateur == null){
            return null;
        }

        return UtilisateurDto.builder()
                .id(utilisateur.getId())
                .firstName(utilisateur.getFirstName())
                .lastName(utilisateur.getLastName())
                .email(utilisateur.getEmail())
                .password(utilisateur.getPassword())
                .adresse(AddressDto.fromEntity(utilisateur.getAdresse()))
                .imageUser(utilisateur.getImageUser())
                .entreprise(EntrepriseDto.fromEntity(utilisateur.getEntreprise()))
                .role(utilisateur.getRole()!= null ?
                        utilisateur.getRole().stream()
                                .map(RoleDto::fromEntity).collect(Collectors.toList()) : null).build();
    }

    public static  Utilisateur toEntity(UtilisateurDto utilisateurDto){
        if(utilisateurDto.canEqual(null)){
            return null;
        }
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(utilisateurDto.getId());
        utilisateur.setFirstName(utilisateurDto.getFirstName());
        utilisateur.setLastName(utilisateurDto.getLastName());
        utilisateur.setEmail(utilisateurDto.getEmail());
        utilisateur.setPassword(utilisateurDto.getPassword());
        utilisateur.setAdresse(utilisateur.getAdresse());
        utilisateur.setImageUser(utilisateur.getImageUser());
        utilisateur.setEntreprise(EntrepriseDto.toEntity(utilisateurDto.getEntreprise()));


        return utilisateur;
    }
}
