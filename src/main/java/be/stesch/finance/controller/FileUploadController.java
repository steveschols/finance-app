package be.stesch.finance.controller;

import be.stesch.finance.service.FileUploadService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

@RestController("/finances")
public class FileUploadController {

    private final Logger logger;
    private final FileUploadService fileUploadService;

    @Autowired
    public FileUploadController(Logger logger, FileUploadService fileUploadService) {
        this.logger = logger;
        this.fileUploadService = fileUploadService;
    }

    @GetMapping("/upload")
    public String index() {
        return "upload";
    }

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
        try {
            String path = fileUploadService.uploadFile(file.getBytes(), file.getOriginalFilename());
            return ok(path);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            return status(BAD_REQUEST).build();
        }
    }

}
