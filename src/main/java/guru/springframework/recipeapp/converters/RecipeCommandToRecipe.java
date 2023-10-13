package guru.springframework.recipeapp.converters;


import guru.springframework.recipeapp.commands.RecipeCommand;
import guru.springframework.recipeapp.domain.Recipe;
import lombok.AllArgsConstructor;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {

    private final CategoryCommandToCategory categoryConverter;
    private final IngredientCommandToIngredient ingredientConverter;
    private final NotesCommandToNotes notesConverter;


    @Override
    @Synchronized
    @Nullable
    public Recipe convert(RecipeCommand source) {
        if (source == null) {
            return null;
        }

        final Recipe recipe = new Recipe();
        recipe.setId(source.getId());
        recipe.setDirections(source.getDirections());
        recipe.setDifficulty(source.getDifficulty());
        recipe.setDescription(source.getDescription());
        recipe.setServings(source.getServings());
        recipe.setUrl(source.getUrl());
        recipe.setCookTime(source.getCookTime());
        recipe.setPrepTime(source.getPrepTime());
        recipe.setSource(source.getSource());
        recipe.setNotes(notesConverter.convert(source.getNotes()));
        if( source.getCategories() != null ){
            source.getCategories().forEach((categoryCommand -> {
                recipe.getCategories().add(categoryConverter.convert(categoryCommand));
            }));
        }

        if(source.getIngredients() != null){
            source.getIngredients().forEach((ingredientCommand -> {
                recipe.addIngredient(ingredientConverter.convert(ingredientCommand));
            }));
        }

        return recipe;
    }
}
