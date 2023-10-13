package guru.springframework.recipeapp.services;

/*
    Created by tylermckenney on 10/13/23.
*/

import guru.springframework.recipeapp.commands.IngredientCommand;
import org.springframework.stereotype.Service;

@Service
public interface IngredientService {

    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
}
