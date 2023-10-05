package guru.springframework.recipeapp.repositories;

/*
    Created by tylermckenney on 10/5/23.
*/

import guru.springframework.recipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String description);
}
