package com.pi.gest.dto;

import com.pi.gest.model.Article;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class ArticleDto {

    private Integer id;
    private Integer idEntreprise;
    private String codeArticle ;
    private String designation ;
    private String ImageArticle;


    private CategoryDto categorie;


    private BigDecimal prixUnitaireHT;
    private BigDecimal TVA;
    private BigDecimal prixUnitaireTTC;

    public static ArticleDto fromEntity(Article article){
        if(article == null){
            return null;
        }
        return ArticleDto.builder()
                .id(article.getId())
                .codeArticle(article.getCodeArticle())
                .designation(article.getDesignation())
                .ImageArticle(article.getImageArticle())
                .prixUnitaireHT(article.getPrixUnitaireHT())
                .prixUnitaireTTC(article.getPrixUnitaireTTC())
                .TVA(article.getTVA())
                .idEntreprise(article.getIdEntreprise())
                .categorie(CategoryDto.fromEntity(article.getCategorie()))
                .build();
        }
    public static Article toEntity(ArticleDto articleDto) {
        if (articleDto == null) {
            return null;
        }
        Article article = new Article();
        article.setCodeArticle(articleDto.getCodeArticle());
        article.setId(articleDto.getId());
        article.setIdEntreprise(articleDto.getIdEntreprise());
        article.setTVA(articleDto.getTVA());
        article.setPrixUnitaireHT(articleDto.getPrixUnitaireHT());
        article.setPrixUnitaireTTC(articleDto.getPrixUnitaireTTC());
        article.setCategorie(CategoryDto.toEntity(articleDto.getCategorie()));

    return article;
    }
}
