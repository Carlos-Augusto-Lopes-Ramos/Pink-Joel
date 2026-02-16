package com.main.medula.controllers;

import com.main.medula.dtos.ImageDTO;
import com.main.medula.services.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/helluva/files")
public class FileController {


    private final FileStorageService fileStorageService;
    @Autowired
    public FileController (FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String fileName = fileStorageService.saveFile(file);
            return ResponseEntity.ok("Arquivo salvo com sucesso: " + fileName);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao salvar arquivo: " + e.getMessage());
        }
    }

    @GetMapping(value = "/base64/{fileName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ImageDTO> getFileAsBase64(@PathVariable String fileName) {
        try {
            String base64 = fileStorageService.getFileAsBase64(fileName);
            return ResponseEntity.ok(new ImageDTO(fileName, base64));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }
}