package com.eric.file_management.service;

import com.eric.file_management.dto.ResponseData;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileService {

    public ResponseData saveFile(String fileName, MultipartFile multipartFile) {
        // B1. Get path of folder to upload file
        Path uploadDirectory = Paths.get("files-upload");
        // B2. Convert multipartfile to inputstream to save new path
        try(InputStream inputStream = multipartFile.getInputStream();) {
            // B3. Get new path for file name
            Path filePath = uploadDirectory.resolve(fileName);
            // B4. Clone inputstream to new file path
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseData.Builder()
                .data(fileName)
                .date()
                .build();
    }
}
