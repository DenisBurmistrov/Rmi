package ru.burmistrov.rmiExample.storage;

import lombok.Data;
import ru.burmistrov.rmiExample.entity.User;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserList {

    private List<User> users;

    public UserList() {
        users = new ArrayList<User>();
    }
}
