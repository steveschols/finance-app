package be.stesch.finance.service;

import java.io.IOException;

public interface FileUploadService {

    String uploadFile(byte[] bytes, String filename) throws IOException;

}
