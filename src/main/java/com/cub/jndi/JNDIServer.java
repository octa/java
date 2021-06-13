package com.cub.jndi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Hashtable;

public class JNDIServer {

    public static Registry registry;
    public static InitialContext initialContext;

    public static void initJNDI() throws RemoteException, NamingException {
        registry = LocateRegistry.createRegistry(1099);
        Hashtable hashtable = new Hashtable();
        hashtable.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
        hashtable.put(Context.PROVIDER_URL, "rmi://localhost:1099");
        initialContext = new InitialContext(hashtable);
    }

    public static void unInitJNDI() throws NamingException {
        initialContext.close();
    }

    public static void bind(String name, Object object) throws NamingException {
        initialContext.bind(name, object);
    }

    public static void unbind(String name) throws NamingException {
        initialContext.unbind(name);
    }

    public static void main(String[] args) throws NamingException, IOException {
        initJNDI();
        RMIServer rmiServer = new RMIServer("Hello World");
        bind("/hi", rmiServer);

        System.in.read();

        unbind("/hi");
        unInitJNDI();
    }

}
