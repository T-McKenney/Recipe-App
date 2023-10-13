package guru.springframework.recipeapp.services;

/*
    Created by tylermckenney on 10/13/23.
*/

import guru.springframework.recipeapp.commands.UnitOfMeasureCommand;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUoms();
}
