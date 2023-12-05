package Observer;

import com.Cockroach.model.Student;

import java.util.ArrayList;
import java.util.List;

public interface CafeSubject {
    void registerObserver(long student_id);
    void removeObserver(long student_id);
    void notifyObservers();
}
