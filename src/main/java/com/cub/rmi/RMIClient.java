package com.cub.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIClient {

    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        RMIServerImpl rmiServerImpl = (RMIServerImpl) Naming.lookup("com.cub.rmi://10.0.0.24/RMIServer");

        rmiServerImpl.remoteObject();

    }
}
