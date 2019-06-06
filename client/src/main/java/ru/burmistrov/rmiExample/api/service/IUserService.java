package ru.burmistrov.rmiExample.api.service;

import ru.burmistrov.rmiExample.entity.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IUserService extends Remote {

    List<User> findAllUsers() throws RemoteException;

    User findOneById(final String id) throws RemoteException;

    User persist(final String username, final String password) throws RemoteException;

    User merge(final String id, final String username, final String password) throws RemoteException;

    void deleteById(final String id) throws RemoteException;
}
