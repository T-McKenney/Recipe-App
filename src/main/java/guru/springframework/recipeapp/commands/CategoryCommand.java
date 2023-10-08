package guru.springframework.recipeapp.commands;

/*
    Created by tylermckenney on 10/7/23.
*/

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CategoryCommand {
    private Long id;
    private String description;
}
