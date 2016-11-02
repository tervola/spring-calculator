package ua.goit.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import ua.goit.task.service.Calculator;
import ua.goit.task.service.Printer;

import java.io.IOException;

/**
 * Created by user on 10/29/2016.
 */
@Component
public class MyCalculator {

    public static void main(String[] args) throws IOException {
        ApplicationContext  context = new ClassPathXmlApplicationContext("application-context.xml", "application-aop-context.xml");

        MyCalculator myCalculator =context.getBean(MyCalculator.class);
        myCalculator.start();
    }

    @Autowired
    Calculator calculator;

    @Autowired
    Printer printer;

    void start() throws IOException {
        calculator.run();
    }
}
