package guru.springframework.recipeapp.services;

/*
    Created by tylermckenney on 10/5/23.
*/

import guru.springframework.recipeapp.commands.RecipeCommand;
import guru.springframework.recipeapp.domain.Recipe;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface RecipeService {

    Set<Recipe> getRecipes();
    Recipe findById(Long aLong);

    RecipeCommand findCommandById(Long aLong);
    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
