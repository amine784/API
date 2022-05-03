package com.pi.gest.dto;



import com.pi.gest.model.Vente;
import lombok.Builder;
import lombok.Data;


import java.time.Instant;
import java.util.List;

@Data
@Builder
public class VenteDto {

    private Integer id;

    private String codeVente;
    private Instant dateVente;
    private String commentaire;
    private Integer idEntreprise;


    private List<LigneVenteDto> ligneVentes;

    public static VenteDto fromEntity(Vente vente) {
        if (vente == null) {
            return null;
        }
        return VenteDto.builder()
                .id(vente.getId())
                .codeVente(vente.getCodeVente())
                .commentaire(vente.getCommentaire())
                .idEntreprise(vente.getIdEntreprise())
                .build();
    }
        public static Vente toEntity(VenteDto venteDto) {
            if (venteDto == null) {
                return null;
            }
            Vente vente =  new Vente();
            vente.setId(venteDto.getId());
            vente.setCodeVente(venteDto.getCodeVente());
            vente.setCommentaire(venteDto.getCommentaire());
            vente.setIdEntreprise(venteDto.getIdEntreprise());

        return vente;
    }
}
