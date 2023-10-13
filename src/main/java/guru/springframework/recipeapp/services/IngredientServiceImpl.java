package guru.springframework.recipeapp.services;

/*
    Created by tylermckenney on 10/13/23.
*/

import guru.springframework.recipeapp.commands.IngredientCommand;
import guru.springframework.recipeapp.converters.IngredientToIngredientCommand;
import guru.springframework.recipeapp.domain.Recipe;
import guru.springframework.recipeapp.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class IngredientServiceImpl implements IngredientService {

    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final RecipeRepository recipeRepository;

    public IngredientServiceImpl(IngredientToIngredientCommand ingredientToIngredientCommand, RecipeRepository recipeRepository) {
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        if (recipeOptional.isEmpty()) {
            //todo impl error handling
            log.error("recipe id not found. Id: " + recipeId);
        }

        Recipe recipe = recipeOptional.get();

        Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getId().equals(ingredientId))
                .map(ingredient -> ingredientToIngredientCommand.convert(ingredient)).findFirst();

        if (ingredientCommandOptional.isEmpty()) {
            //todo impl error handling
            log.error("Ingredient id not found: " + ingredientId);
        }

        return ingredientCommandOptional.get();
    }
}
