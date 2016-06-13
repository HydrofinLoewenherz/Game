package net.colorman.handler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul on 13.06.2016.
 */
public class ExceptionHandler {

    List<String> exceptions;

    public ExceptionHandler() {
        exceptions = new ArrayList<>();
    }

    public void addException(String element, String exception) {
        exceptions.add(element);
        exceptions.add(exception);
    }

    public List<String> getExceptions() {
        return exceptions;
    }
}
