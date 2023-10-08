package guru.springframework.recipeapp.commands;

/*
    Created by tylermckenney on 10/7/23.
*/

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UnitOfMeasureCommand {
    private Long id;
    private String description;
}
