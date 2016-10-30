package ua.goit.task.repo;

import org.springframework.stereotype.Component;

/**
 * Created by user on 10/29/2016.
 */
@Component
public class Devide implements MyOperation {
    @Override
    public Number execute(String firstNumber, String secondNumber) {

        Number result = 0;
        if(firstNumber.contains(".") || secondNumber.contains(".")){
            Double fn = Double.parseDouble(firstNumber);
            Double sn = Double.parseDouble(secondNumber);
            if (sn == 0){
                throw new ArithmeticException("Deny operation: second operand is Zero");
            }
            result = fn / sn;
        } else {
            long fn = Long.parseLong(firstNumber);
            long sn = Long.parseLong(secondNumber);

            if (sn == 0){
                throw new ArithmeticException("Deny operation: second operand is Zero");
            }
            result = fn / sn;
        }
        return result;
    }
}
