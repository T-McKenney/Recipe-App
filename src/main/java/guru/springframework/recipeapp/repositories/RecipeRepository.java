package guru.springframework.recipeapp.repositories;

/*
    Created by tylermckenney on 10/5/23.
*/

import guru.springframework.recipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
