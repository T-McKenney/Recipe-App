package guru.springframework.recipeapp.domain;

/*
    Created by tylermckenney on 10/5/23.
*/

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public  class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
}
