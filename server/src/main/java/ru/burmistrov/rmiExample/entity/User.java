package ru.burmistrov.rmiExample.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class User implements Serializable {

    private String id = UUID.randomUUID().toString();

    private String username;

    private String password;
}
