package ua.goit.task.repo;

import org.springframework.stereotype.Component;

/**
 * Created by user on 10/29/2016.
 */
@Component
public class Plus implements MyOperation {
    @Override
    public Number execute(String firstNumber, String secondNumber) {
        Number result = 0;
        if(firstNumber.contains(".") || secondNumber.contains(".")){
            Double fn = Double.parseDouble(firstNumber);
            Double sn = Double.parseDouble(secondNumber);
            result = fn + sn;
        } else {
            long fn = Long.parseLong(firstNumber);
            long sn = Long.parseLong(secondNumber);
            if (fn > Integer.MAX_VALUE || sn > Integer.MAX_VALUE || fn < Integer.MIN_VALUE || sn < Integer.MIN_VALUE){
                result = fn + sn;
            } else {
                result = (int)fn + (int)sn;
            }
        }
        return result;
    }
}
