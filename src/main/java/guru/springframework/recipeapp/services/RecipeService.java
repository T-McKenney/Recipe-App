package guru.springframework.recipeapp.services;

/*
    Created by tylermckenney on 10/5/23.
*/

import guru.springframework.recipeapp.commands.RecipeCommand;
import guru.springframework.recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
    Recipe findById(Long aLong);

    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
