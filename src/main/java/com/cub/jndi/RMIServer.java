package com.cub.jndi;

import java.io.Serializable;
import java.rmi.Remote;

public class RMIServer implements Remote, Serializable {

    String message;

    public RMIServer(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
