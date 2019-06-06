package ru.burmistrov.rmiExample.service;


import ru.burmistrov.rmiExample.api.service.IUserService;
import ru.burmistrov.rmiExample.entity.User;
import ru.burmistrov.rmiExample.storage.UserList;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class UserService extends UnicastRemoteObject implements IUserService {

    private UserList userList;

    public UserService() throws RemoteException {
        userList = new UserList();
    }

    public List<User> findAllUsers() {
        return userList.getUsers();
    }

    public User findOneById(final String id){
        for (User user : userList.getUsers()) {
            if (id.equals(user.getId()))
                return user;
        }
        return null;
    }

    public User persist(final String username, final String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userList.getUsers().add(user);
        return user;
    }

    public User merge(final String id, final String username, final String password) {
        User user = findOneById(id);
        if(user != null) {
            userList.getUsers().remove(user);
            user.setUsername(username);
            user.setPassword(password);
            userList.getUsers().add(user);
            return user;
        }
        return null;
    }

    public void deleteById(final String id){
        User user = findOneById(id);
        if(user != null) {
            userList.getUsers().remove(user);
        }
    }
}
