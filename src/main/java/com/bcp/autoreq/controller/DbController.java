package com.bcp.autoreq.controller;

import com.bcp.autoreq.Dao.DbDao;
import com.bcp.autoreq.Service.DbService;
import com.bcp.autoreq.model.Db;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DbController {

    @Autowired
    private DbService dbService;

    @PostMapping(value = "/db")
    public void configDb(@RequestBody Db database){
        dbService.saveDb(database);
    }
}
