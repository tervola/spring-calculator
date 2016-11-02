package ua.goit.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ua.goit.task.repo.MyOperation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/**
 * Created by user on 10/29/2016.
 */
@Component
public class CalculatorImpl implements Calculator {

    /**выражение может иметь вид :
    2+3
     2 + 3
     +2 3
     2 3 +
     1,3,+
     +,2,1
    */
    List<Character> operations;
    char currentOperation;
    MyOperation myOperation;

    @Autowired
    @Qualifier("plus")
    MyOperation plus;
    @Autowired
    @Qualifier("minus")
    MyOperation minus;
    @Autowired
    @Qualifier("multiple")
    MyOperation multiple;
    @Autowired
    @Qualifier("devide")
    MyOperation devide;


    public CalculatorImpl() {
        this.operations = Arrays.asList('*','/','+','-');
        this.currentOperation = ' ';
    }

    @Override
    public String calculation(String expression) {

        if(expression.contains(",")){
            expression = expression.replaceAll(","," ");
        }

        char[] expr = expression.toLowerCase().trim().toCharArray();
        boolean firstDigitDefine = false;
        boolean unknownOperation = true;

        StringBuilder fd = new StringBuilder();
        StringBuilder sd = new StringBuilder();


        for (int i = 0; i < expr.length; i++) {
            char currentChar = expr[i];
            boolean potentialDigit = definePotentialDigit(currentChar);
            if(i == 0 && (!potentialDigit ) && unknownOperation){
                if (operations.contains(currentChar)){
                    this.currentOperation = currentChar;
                    unknownOperation = false;
                    continue;
                }
            }
            if (Character.isSpaceChar(currentChar) && fd.length() == 0){
                continue;
            }

            if(potentialDigit && !firstDigitDefine){
                fd.append(currentChar);
                continue;
            }

            if(!potentialDigit){
                if (Character.isSpaceChar(currentChar)) {
                    if(fd.length() > 0){
                        firstDigitDefine = true;
                    }
                    continue;
                }
                if (operations.contains(currentChar)){
                    this.currentOperation = currentChar;
                    unknownOperation = false;
                    firstDigitDefine = true;
                    continue;
                }
            }

            sd.append(currentChar);
        }

        switch (this.currentOperation){
            case '+' :
                myOperation = plus;
                break;
            case '-' :
                myOperation = minus;
                break;
            case '*' :
                myOperation = multiple;
                break;
            case '/' :
                myOperation = devide;
                break;

            default:
                throw new ArithmeticException("Unknow operation");
        }
        Number result  = myOperation.execute(fd.toString(), sd.toString());
        return toString(fd.toString(), sd.toString(), result);
    }

    @Override
    public String toString(String f, String s, Number value) {
        return String.format("%s %s %s = %s", f, this.currentOperation, s, value);
    }

    @Autowired
    Printer printer;

    @Override
    public void run() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        printer.print("Input Expression:");
        String inputedExpression = reader.readLine();
        String result  = calculation(inputedExpression);

        printer.print(result);
    }

    private boolean definePotentialDigit(char currentChar) {
        return Character.isDigit(currentChar) || currentChar == '.';
    }

}
