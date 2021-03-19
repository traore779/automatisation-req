package com.bcp.autoreq.Service;

import com.bcp.autoreq.model.Db;
import org.springframework.http.ResponseEntity;

public interface DbService {

    public ResponseEntity saveDb(Db db);
}
