package guru.springframework.recipeapp.domain;

/*
    Created by tylermckenney on 10/5/23.
*/

import jakarta.persistence.*;
import lombok.*;


import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"recipes"})
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;

}
