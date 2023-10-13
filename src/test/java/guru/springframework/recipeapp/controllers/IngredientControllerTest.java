package guru.springframework.recipeapp.controllers;

/*
    Created by tylermckenney on 10/13/23.
*/

import guru.springframework.recipeapp.commands.IngredientCommand;
import guru.springframework.recipeapp.commands.RecipeCommand;
import guru.springframework.recipeapp.services.IngredientService;
import guru.springframework.recipeapp.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class IngredientControllerTest {

    @Mock
    RecipeService recipeService;

    @Mock
    IngredientService ingredientService;

    IngredientController controller;

    AutoCloseable openMocks;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        openMocks = openMocks(this);

        controller = new IngredientController(recipeService, ingredientService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testListIngredients() throws Exception {

        //given
        RecipeCommand recipeCommand = new RecipeCommand();
        when(recipeService.findCommandById(anyLong())).thenReturn(recipeCommand);

        //when
        mockMvc.perform(get("/recipe/1/ingredients"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/ingredient/list"))
                .andExpect(model().attributeExists("recipe"));

        //then
        verify(recipeService, times(1)).findCommandById(anyLong());
    }

    @Test
    void testShowIngredient() throws Exception {

        //given
        IngredientCommand ingredientCommand = new IngredientCommand();

        //when
        when(ingredientService.findByRecipeIdAndIngredientId(anyLong(), anyLong())).thenReturn(ingredientCommand);

        //then
        mockMvc.perform(get("/recipe/1/ingredient/2/show"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/ingredient/show"))
                .andExpect(model().attributeExists("ingredient"));
    }
}
