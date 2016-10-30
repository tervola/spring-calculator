package ua.goit.task.repo;

import org.springframework.stereotype.Component;

/**
 * Created by user on 10/29/2016.
 */

@Component
public class Multiple implements MyOperation {
    @Override
    public Number execute(String firstNumber, String secondNumber) {

        Number result = 0;
        if(firstNumber.contains(".") || secondNumber.contains(".")){
            Double fn = Double.parseDouble(firstNumber);
            Double sn = Double.parseDouble(secondNumber);
            result = fn * sn;
        } else {
            long fn = Long.parseLong(firstNumber);
            long sn = Long.parseLong(secondNumber);
            long tmp = fn * sn;
            if (tmp < Integer.MIN_VALUE || tmp > Integer.MAX_VALUE){
                result = tmp;
            } else {
                result = (int)tmp;
            }
        }
        return result;
    }
}
