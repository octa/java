package com.cub.jndi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Hashtable;


/*

1. Define properties for InitialContext
2. Create InitialConext
3. Bind objects to the context
4. Unbind when done
5. Close

 */

public class JNDIServer {

    public static Registry registry;
    public static InitialContext initialContext;

    public static void initJNDI() throws RemoteException, NamingException {
        registry = LocateRegistry.createRegistry(1099); //Create an RMI registry. If this were DNS or any other SPI, it would have started externally. RMI could be started externally via the rmiregistry command as well but doing it here in code.
        Hashtable hashtable = new Hashtable(); //Create a hashtable of all the properties to pass to InitialContext when creating the Context.
        hashtable.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory"); //Factory of SPI. In this case, it is RMI.
        hashtable.put(Context.PROVIDER_URL, "rmi://localhost:1099"); //Provider URL.
        initialContext = new InitialContext(hashtable); //Create the context.
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
