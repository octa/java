package com.cub.jndi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

/*

1. Define properties for InitialContext
2. Create InitialConext
3. Lookup the JNDI registry
4. Close

 */

public class JNDIClient {

    public static void main(String[] args) throws NamingException {
        InitialContext initialContext;

        Hashtable hashtable = new Hashtable();
        hashtable.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
        hashtable.put(Context.PROVIDER_URL, "rmi://localhost:1099");

        initialContext = new InitialContext(hashtable);

        RMIServer rmiServer = (RMIServer) initialContext.lookup("/hi");
        String message = rmiServer.getMessage();

        System.out.println(message);

        initialContext.close();
    }

}
