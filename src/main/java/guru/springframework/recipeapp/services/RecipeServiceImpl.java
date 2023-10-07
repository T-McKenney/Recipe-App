package guru.springframework.recipeapp.services;

/*
    Created by tylermckenney on 10/5/23.
*/

import guru.springframework.recipeapp.domain.Recipe;
import guru.springframework.recipeapp.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {

        log.debug("Im in the service");

        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }

    @Override
    public Recipe findById(Long aLong) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(aLong);

        if(recipeOptional.isEmpty()) {
            throw new RuntimeException("Recipe not found!");
        }

        return recipeOptional.get();
    }


}
