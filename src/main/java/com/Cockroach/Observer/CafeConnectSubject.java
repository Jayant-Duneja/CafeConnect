package com.Cockroach.Observer;
import java.util.Observable;

public class CafeConnectSubject extends Observable {
    private String message;
    public void setMessage(String message) {
        this.message = message;
        setChanged();
        notifyObservers(message);
    }

    public String getMessage() {
        return message;
    }
}
