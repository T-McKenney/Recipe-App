package guru.springframework.recipeapp.services;

/*
    Created by tylermckenney on 10/14/23.
*/

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface ImageService {

    void saveImageFile(Long recipeId, MultipartFile file);
}
