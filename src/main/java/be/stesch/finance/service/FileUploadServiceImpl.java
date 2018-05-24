package be.stesch.finance.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class FileUploadServiceImpl implements FileUploadService {

    @Value("file.upload.path")
    private String uploadFolder;

    @Override
    public String uploadFile(byte[] bytes, String filename) throws IOException {
        Path path = Paths.get(uploadFolder + filename);
        Files.write(path, bytes);

        return path.toString();
    }

}
