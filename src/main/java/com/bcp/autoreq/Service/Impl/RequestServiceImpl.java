package com.bcp.autoreq.Service.Impl;

import com.bcp.autoreq.Dao.RequestDao;
import com.bcp.autoreq.Service.RequestService;
import com.bcp.autoreq.model.Request;
import com.bcp.autoreq.property.RequestStorageProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestDao requestDao;

    private Path reqStorageLoc;

    @Autowired
    public RequestServiceImpl(RequestStorageProperty requestStorageProperty) {
        try {
            this.reqStorageLoc = Paths.get(requestStorageProperty.getUploadDir()).toAbsolutePath().normalize();
            Files.createDirectories(this.reqStorageLoc);
        } catch (Exception e){
            System.out.println("Error occurred !!!!!!");
        }
    }

    @Override
    @Transactional
    public void saveRequest(MultipartFile multipartFile) throws IOException {
        Request request= new Request();
        request.setDesignation(multipartFile.getName());
        request.setContent(multipartFile.getBytes());
        storeRequest(multipartFile, request.getDesignation());
        requestDao.save(request);
    }

    private void storeRequest(MultipartFile file, String name) throws IOException {
        Path targetLocation = this.reqStorageLoc.resolve(name);
        Files.copy(file.getInputStream(), targetLocation);
    }
}
