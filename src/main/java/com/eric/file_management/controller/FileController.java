package com.eric.file_management.controller;

import com.eric.file_management.dto.ResponseData;
import com.eric.file_management.service.FileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/file")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("File Page!!!");
    }

    @PostMapping("/upload")
    public ResponseEntity<ResponseData> uploadFile(@RequestParam(value = "file", required = false) MultipartFile multipartFile) {
        String fileName = multipartFile.getOriginalFilename();
        ResponseData response = fileService.saveFile(fileName, multipartFile);
        return ResponseEntity.ok(new ResponseData.Builder()
                                    .data(response)
                                    .date().build());
    }
}
