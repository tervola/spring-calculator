package ua.goit.task.service;

import java.io.IOException;

/**
 * Created by user on 10/29/2016.
 */
public interface Calculator {
    String calculation(String expression);

    String toString(String s, String toString, Number value);

    void run() throws IOException;
}
