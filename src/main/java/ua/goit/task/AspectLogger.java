package ua.goit.task;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


/**
 * Created by user on 10/31/2016.
 */
@Aspect
public class AspectLogger {

    final static Logger logger = Logger.getLogger(AspectLogger.class);

//    final static Logger LOG = LogManager.getLogger(String.valueOf(AspectLogger.class));

//    @Before("execution(* ua.goit.task.service.CalculatorImpl.*())")
//    public void logBeforeExecution(JoinPoint joinPoint){
//        System.out.println("*************");
//        System.out.println("logBeforeExecution() is running!");
//        System.out.println("hijacked : " + joinPoint.getSignature().getName());
//        System.out.println("*************");
//    }

    @Before("execution(* ua.goit.task.service.*.*())")
    public void logBeforeExecutionlog4j(JoinPoint joinPoint){
        logger.info("*************");
        logger.info("logBeforeExecutionlog4j() is running!");
        logger.info("hijacked : " + joinPoint.getSignature().getName());
        logger.info("*************");
    }

//    @After("execution(* ua.goit.task.service.CalculatorImpl.*())")
//    public void logAfterExecution(JoinPoint joinPoint){
//        System.out.println("*************");
//        System.out.println("logAfterExecution() is running!");
//        System.out.println("hijacked : " + joinPoint.getSignature().getName());
//        System.out.println("*************");
//    }
//
//    @AfterReturning(
//            pointcut = "execution(* ua.goit.task.service.CalculatorImpl.*())",
//            returning= "result")
//    public void logAfterReturning(JoinPoint joinPoint, Object result) {
//
//        System.out.println("*************");
//        System.out.println("logAfterReturning(..) is running!");
//        System.out.println("hijacked : " + joinPoint.getSignature().getName());
//        System.out.println("hijacked : " + joinPoint.getKind());
//        System.out.println("Method returned value is : " + result);
//        System.out.println("******");
//
//    }
//
//    @AfterThrowing(
//            pointcut = "execution(* ua.goit.task.service.CalculatorImpl.*())",
//            throwing= "error")
//    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
//
//        System.out.println("\n******");
//        System.out.println("logAfterThrowing() is running!");
//        System.out.println("hijacked : " + joinPoint.getSignature().getName());
//        System.out.println("Exception : " + error);
//        System.out.println("******");
//    }
//
//    @Around("execution(* ua.goit.task.service.CalculatorImpl.*())")
//    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
//
//        System.out.println("logAround() is running!");
//        System.out.println("hijacked method : " + joinPoint.getSignature().getName());
//        System.out.println("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));
//
//        System.out.println("Around before is running!");
//        joinPoint.proceed(); //continue on the intercepted method
//        System.out.println("Around after is running!");
//
//        System.out.println("******");
//
//    }

    /**
        //TODO: all possible situations
        // Try log4j
        //https://www.mkyong.com/spring3/spring-aop-aspectj-annotation-example/
         */
}
