package com.bcp.autoreq.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String designation;

    @Lob
    private byte[] content;

    public String setHash() throws NoSuchAlgorithmException {
        return new StringBuilder().append(this.designation)
                .append(new Date().getTime()).toString();
    }
}
