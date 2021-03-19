package com.bcp.autoreq.Dao;

import com.bcp.autoreq.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestDao extends JpaRepository<Request, Long> {

}
