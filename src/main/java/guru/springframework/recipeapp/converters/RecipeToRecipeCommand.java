package guru.springframework.recipeapp.converters;


import guru.springframework.recipeapp.commands.RecipeCommand;
import guru.springframework.recipeapp.domain.Category;
import guru.springframework.recipeapp.domain.Recipe;
import lombok.AllArgsConstructor;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {

    private final CategoryToCategoryCommand categoryConverter;
    private final IngredientToIngredientCommand ingredientConverter;
    private final NotesToNotesCommand notesConverter;

    @Override
    @Synchronized
    @Nullable
    public RecipeCommand convert(Recipe source) {
        if (source == null)
            return null;

        final RecipeCommand command = new RecipeCommand();
        command.setId(source.getId());
        command.setCookTime(source.getCookTime());
        command.setPrepTime(source.getPrepTime());
        command.setDescription(source.getDescription());
        command.setDifficulty(source.getDifficulty());
        command.setDirections(source.getDirections());
        command.setServings(source.getServings());
        command.setSource(source.getSource());
        command.setUrl(source.getUrl());
        command.setNotes(notesConverter.convert(source.getNotes()));

        if( source.getIngredients() != null ){
            source.getIngredients().forEach((ingredient -> {
                command.getIngredients().add(ingredientConverter.convert(ingredient));
            }));
        }
        if( source.getCategories() != null ){
            source.getCategories().forEach((category -> {
                command.getCategories().add(categoryConverter.convert(category));
            }));
        }

        return command;
    }
}
