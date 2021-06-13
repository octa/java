package com.cub.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIServer extends Remote {

    public void remoteObject() throws RemoteException;

}
