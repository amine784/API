package com.pi.gest.services.implementation;


import com.pi.gest.dto.CategoryDto;
import com.pi.gest.exception.EntityNotFoundException;
import com.pi.gest.exception.Errors;
import com.pi.gest.exception.InvalidEntityException;
import com.pi.gest.exception.InvalidOperationException;
import com.pi.gest.model.Article;
import com.pi.gest.repository.ArticleRepository;
import com.pi.gest.repository.CategoryRepository;
import com.pi.gest.services.CategoryService;
import com.pi.gest.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {



    private CategoryRepository categoryRepository;
    private ArticleRepository articleRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ArticleRepository articleRepository) {
        this.categoryRepository = categoryRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public CategoryDto save(CategoryDto dto) {
        List<String> errors = CategoryValidator.validator(dto);
        if (!errors.isEmpty()) {
            log.error("Article is not valid {}", dto);
            throw new InvalidEntityException("La category n'est pas valide", Errors.CATEGORY_NOT_VALID, errors);
        }
        return CategoryDto.fromEntity(
                categoryRepository.save(CategoryDto.toEntity(dto))
        );
    }

    @Override
    public CategoryDto findById(Integer id) {
        if (id == null) {
            log.error("Category ID is null");
            return null;
        }
        return categoryRepository.findById(id)
                .map(CategoryDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune category avec l'ID = " + id + " n' ete trouve dans la BDD",
                        Errors.CATEGORY_NOT_FOUND)
                );
    }

    @Override
    public CategoryDto findByCode(String codeCategory) {
        if (!StringUtils.hasLength(codeCategory)) {
            log.error("Category CODE is null");
            return null;
        }
        return categoryRepository.findCategoryByCode(codeCategory)
                .map(CategoryDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune category avec le CODE = " + codeCategory + " n' ete trouve dans la BDD",
                        Errors.CATEGORY_NOT_FOUND)
                );
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Category ID is null");
            return;
        }
        List<Article> articles = articleRepository.findAllByCategoryId(id);
        if (!articles.isEmpty()) {
            throw new InvalidOperationException("Impossible de supprimer cette categorie qui est deja utilise",
                    Errors.CATEGORY_ALREADY_IN_USE);
        }
        categoryRepository.deleteById(id);
    }

}


