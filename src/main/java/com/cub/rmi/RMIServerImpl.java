package com.cub.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIServerImpl extends UnicastRemoteObject implements RMIServer {

    RMIServerImpl() throws RemoteException {
        super();
    }

    public static void main(String[] args) throws MalformedURLException, RemoteException {

        RMIServerImpl rmiServer = new RMIServerImpl();
        Naming.rebind("RMIServer", rmiServer);

    }

    @Override
    public void remoteObject() {
        System.out.println("Hi");
    }
}
