package com.bcp.autoreq.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface RequestService {
    void saveRequest(MultipartFile multipartFile) throws IOException;
}
