package com.pi.gest.dto;

import com.pi.gest.model.Entreprise;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class EntrepriseDto {

    private Integer id;


    private AddressDto adresse;
    private String nomEntreprise;
    private String codeFiscal;
    private String imageEntreprise;
    private String email;
    private String numtel;
    private String webSite;
    private String description;


    private List<UtilisateurDto> utilisateurs;


    public static EntrepriseDto fromEntity(Entreprise entreprise){
        if(entreprise == null) {return null;}
        return EntrepriseDto.builder()
                .id(entreprise.getId())
                .nomEntreprise(entreprise.getNomEntreprise())
                .description(entreprise.getDescription())
                .adresse(AddressDto.fromEntity(entreprise.getAdresse()))
                .codeFiscal(entreprise.getCodeFiscal())
                .imageEntreprise(entreprise.getImageEntreprise())
                .email(entreprise.getEmail())
                .webSite(entreprise.getWebSite())
                .numtel(entreprise.getNumtel())
                .build();
        }

    public static Entreprise toEntity(EntrepriseDto entrepriseDto){
        Entreprise entreprise =  new Entreprise();
        entreprise.setId(entrepriseDto.getId());
        entreprise.setNomEntreprise(entrepriseDto.getNomEntreprise());
        entreprise.setImageEntreprise(entreprise.getImageEntreprise());
        entreprise.setAdresse(AddressDto.toEntity(entrepriseDto.getAdresse()));
        entreprise.setEmail(entrepriseDto.getEmail());
        entreprise.setWebSite(entrepriseDto.getWebSite());
        entreprise.setCodeFiscal(entrepriseDto.getCodeFiscal());

        return entreprise;

    }
}
