package ru.burmistrov.rmiExample;

import ru.burmistrov.rmiExample.service.UserService;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) throws NamingException, RemoteException {
        LocateRegistry.createRegistry(1099);
        Context context = new InitialContext();
        context.rebind("rmi://localhost:1099/userService", new UserService());
        //context.bind("rmi:userService", new IMathImpl());
        //Naming.bind("userService", new UserService());
    }
}
