package guru.springframework.recipeapp.repositories;

/*
    Created by tylermckenney on 10/5/23.
*/

import guru.springframework.recipeapp.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
}
