package com.bcp.autoreq.controller;

import com.bcp.autoreq.Service.RequestService;
import com.bcp.autoreq.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class RequestController {

    @Autowired
    private RequestService requestService;

    @PostMapping("/request")
    public ResponseEntity<Void> saveReq(@RequestParam(value = "request") MultipartFile multipartFile){
        try {
            requestService.saveRequest(multipartFile);
            return new ResponseEntity("Succes", HttpStatus.CREATED);
        }catch (IOException ioe){
            return new ResponseEntity("Echec", HttpStatus.SEE_OTHER);
        }
    }
}
