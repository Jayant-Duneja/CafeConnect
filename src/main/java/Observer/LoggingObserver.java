package Observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Observable;
import java.util.Observer;

public class LoggingObserver implements Observer {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingObserver.class);
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("I am inside the Update function of the Logger");
        LOGGER.debug("Log: {}", arg);
    }
}

