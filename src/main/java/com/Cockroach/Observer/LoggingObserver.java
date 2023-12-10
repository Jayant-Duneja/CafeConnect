package com.Cockroach.Observer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Observable;
import java.util.Observer;

public class LoggingObserver implements Observer {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingObserver.class);
    private static final String LOG_FILE_PATH = "application.log";
    @Override
    public void update(Observable o, Object arg) {
        logToFile(arg.toString());
    }
    private void logToFile(String logMessage) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE_PATH, true))) {
            writer.println("Log: " + logMessage);
        } catch (Exception e) {
            LOGGER.error("Error writing to log file", e);
        }
    }

}
