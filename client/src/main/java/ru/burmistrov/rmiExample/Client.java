package ru.burmistrov.rmiExample;

import ru.burmistrov.rmiExample.api.service.IUserService;
import ru.burmistrov.rmiExample.entity.User;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.util.Enumeration;

public class Client {
    public static void main(String[] args) throws NamingException, RemoteException {
        Context context = new InitialContext();

        IUserService userService = (IUserService) context.lookup("rmi://localhost:1099/userService");
        User user = userService.persist("test", "test");
        System.out.println("Persist: " + user);
        System.out.println("Find all: " + userService.findAllUsers());
        System.out.println("Merge: " + userService.merge(user.getId(), "test merge", "test merge"));
        System.out.println("Find all: " + userService.findAllUsers());
        userService.deleteById(user.getId());
        System.out.println("Find all after delete: " + userService.findAllUsers());
    }
}
