package com.pi.gest.services;

import com.pi.gest.dto.ArticleDto;
import com.pi.gest.dto.LigneCommandeClientDto;
import com.pi.gest.dto.LigneCommandeFournisseurDto;
import com.pi.gest.dto.LigneVenteDto;

import java.util.List;

public interface ArticleService {
    ArticleDto save(ArticleDto dto);

    ArticleDto findById(Integer id);

    ArticleDto findByCodeArticle(String codeArticle);

    List<ArticleDto> findAll();

    List<LigneVenteDto> findHistoriqueVentes(Integer idArticle);

    List<LigneCommandeClientDto> findHistoriqueCommandeClient(Integer idArticle);

    List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(Integer idArticle);

    List<ArticleDto> findAllArticleByIdCategory(Integer idCategory);

    void delete(Integer id);

}
