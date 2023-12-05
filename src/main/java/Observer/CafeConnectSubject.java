package Observer;

import com.Cockroach.model.Student;

import java.util.ArrayList;
import java.util.List;
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
