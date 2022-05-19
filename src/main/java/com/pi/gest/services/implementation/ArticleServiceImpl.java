package com.pi.gest.services.implementation;

import com.pi.gest.dto.ArticleDto;
import com.pi.gest.dto.LigneCommandeClientDto;
import com.pi.gest.dto.LigneCommandeFournisseurDto;
import com.pi.gest.dto.LigneVenteDto;
import com.pi.gest.exception.EntityNotFoundException;
import com.pi.gest.exception.Errors;
import com.pi.gest.exception.InvalidEntityException;
import com.pi.gest.exception.InvalidOperationException;
import com.pi.gest.model.LigneCommandeClient;
import com.pi.gest.model.LigneCommandeFournisseur;
import com.pi.gest.model.LigneVente;
import com.pi.gest.repository.ArticleRepository;
import com.pi.gest.repository.LigneCommandeClientRepository;
import com.pi.gest.repository.LigneCommandeFournisseurRepository;
import com.pi.gest.repository.LigneVenteRepository;
import com.pi.gest.services.ArticleService;
import com.pi.gest.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;
    private LigneVenteRepository venteRepository;
    private LigneCommandeFournisseurRepository commandeFournisseurRepository;
    private LigneCommandeClientRepository commandeClientRepository;


    @Override
    public ArticleDto save(ArticleDto dto) {
        List<String> errors = ArticleValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("L'article n'est pas valide {}", dto);
            throw new InvalidEntityException("L'article n'est pas valide", Errors.ARTICLE_NOT_VALID, errors);
        }

        return ArticleDto.fromEntity(articleRepository.save(ArticleDto.toEntity(dto)));
    }

    @Override
    public ArticleDto findById(Integer id) {
        if (id == null) {
            log.error("Article ID is null");
            return null;
        }

        return articleRepository.findById(id).map(ArticleDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException("Aucun article avec l'ID = " + id + " n' ete trouve dans la BD", Errors.ARTICLE_NOT_FOUND));
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        if (!StringUtils.hasLength(codeArticle)) {
            log.error("Article CODE is null");
            return null;
        }

        return articleRepository.findArticleByCodeArticle(codeArticle)
                .map(ArticleDto::fromEntity)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Aucun article avec le CODE = " + codeArticle + "dans la BDD",
                                Errors.ARTICLE_NOT_FOUND)
                );
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<LigneVenteDto> findHistoriqueVentes(Integer idArticle) {
        return venteRepository.findAllByArticleId(idArticle).stream().map(LigneVenteDto::fromEntity).collect(Collectors.toList());
    }



    @Override
    public List<LigneCommandeClientDto> findHistoriqueCommandeClient(Integer idArticle) {

        return commandeClientRepository.findAllByArticleId(idArticle).stream().map(LigneCommandeClientDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(Integer idArticle) {
        return commandeFournisseurRepository.findAllByArticleId(idArticle).stream().map(LigneCommandeFournisseurDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public List<ArticleDto> findAllArticleByIdCategory(Integer idCategory) {

        return articleRepository.findAllByCategoryId(idCategory).stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {

        if (id == null) {
            log.error("Article ID is null");
            return;
        }
        List<LigneCommandeClient> ligneCommandeClients = commandeClientRepository.findAllByArticleId(id);
        if (!ligneCommandeClients.isEmpty()) {
            throw new InvalidOperationException("Impossible de supprimer un article deja utilise dans des commandes client", Errors.ARTICLE_ALREADY_IN_USE);
        }
        List<LigneCommandeFournisseur> ligneCommandeFournisseurs = commandeFournisseurRepository.findAllByArticleId(id);
        if (!ligneCommandeFournisseurs.isEmpty()) {
            throw new InvalidOperationException("Impossible de supprimer un article deja utilise dans des commandes fournisseur",
                    Errors.ARTICLE_ALREADY_IN_USE);
        }
        List<LigneVente> ligneVentes = venteRepository.findAllByArticleId(id);
        if (!ligneVentes.isEmpty()) {
            throw new InvalidOperationException("Impossible de supprimer un article deja utilise dans des ventes",
                    Errors.ARTICLE_ALREADY_IN_USE);
        }
        articleRepository.deleteById(id);
    }


}
