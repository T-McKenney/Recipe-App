package guru.springframework.recipeapp.services;

/*
    Created by tylermckenney on 10/5/23.
*/

import guru.springframework.recipeapp.commands.RecipeCommand;
import guru.springframework.recipeapp.converters.RecipeCommandToRecipe;
import guru.springframework.recipeapp.converters.RecipeToRecipeCommand;
import guru.springframework.recipeapp.domain.Recipe;
import guru.springframework.recipeapp.exceptions.NotFoundException;
import guru.springframework.recipeapp.repositories.RecipeRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    @Override
    public Set<Recipe> getRecipes() {

        log.debug("Entering getRecipes");
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        log.info("Exiting getRecipes");
        return recipeSet;
    }

    @Override
    public Recipe findById(Long aLong) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(aLong);

        if (recipeOptional.isEmpty()) {
            throw new NotFoundException("Recipe not found for ID value: " + aLong.toString());
        }
        return recipeOptional.get();
    }

    @Override
    @Transactional
    public RecipeCommand findCommandById(Long aLong) {
        log.info("Entering findCommandById for: " + aLong);
        Recipe recipe = findById(aLong);
        RecipeCommand recipeCommand = recipeToRecipeCommand.convert(recipe);
        log.info("Exiting findCommandById for: " + aLong );
        return recipeCommand;
    }

    @Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand) {

        log.info("Entering saveRecipeCommand for:" + recipeCommand.getDescription());
        Recipe recipe = recipeCommandToRecipe.convert(recipeCommand);
        assert recipe != null;
        Recipe savedRecipe = recipeRepository.save(recipe);
        RecipeCommand detachRecipeCommand = recipeToRecipeCommand.convert(savedRecipe);
        log.info("Exiting savRecipeCommand for: " + recipeCommand.getDescription());
        return detachRecipeCommand;
    }

    @Override
    public void deleteById(Long idToDelete) {
        recipeRepository.deleteById(idToDelete);
    }
}
