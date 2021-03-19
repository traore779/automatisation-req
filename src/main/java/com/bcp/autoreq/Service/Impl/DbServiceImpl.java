package com.bcp.autoreq.Service.Impl;

import com.bcp.autoreq.Dao.DbDao;
import com.bcp.autoreq.Service.DbService;
import com.bcp.autoreq.model.Db;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DbServiceImpl implements DbService {

    @Autowired
    private DbDao dbDao;

    @Override
    public ResponseEntity saveDb(Db db) {
        Db database = dbDao.save(db);
        return new ResponseEntity(database, HttpStatus.CREATED);
    }
}
