package com.cachinginapp.enterprise.dao;

import com.cachinginapp.enterprise.dto.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IPhotoDAO {
    void save(Photo photo);

    void saveImage(MultipartFile imageFile, Photo photo) throws IOException;
}
