package edu.snnu.startyun.aspect;/*
package edu.snnu.startyun.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(public int edu.snnu.spring_apo.calculator.calculatorImpl.ArithmeticCalculatorImpl.*(int, int))")
    public void beforeMethod(JoinPoint joinPoint) {
        String studentName = joinPoint.getSignature().getStudentName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method " +studentName + " begins with " + args);
    }

    @After("execution( int edu.snnu.spring_apo.calculator.calculatorImpl.ArithmeticCalculatorImpl.*(int, int))")
    public void afterMethod(JoinPoint joinPoint) {
        String studentName = joinPoint.getSignature().getStudentName();
        System.out.println("The method " +studentName + " ends");
    }

    @AfterReturning(value = "execution( int edu.snnu.spring_apo.calculator.calculatorImpl.ArithmeticCalculatorImpl.*(int, int))",returning = "result")
    public void afterReturnMethod(JoinPoint joinPoint, Object result) {
        String studentName = joinPoint.getSignature().getStudentName();
        System.out.println("The method " +studentName + " ends with " + result);
    }

    @AfterThrowing(value = "execution( int edu.snnu.spring_apo.calculator.calculatorImpl.ArithmeticCalculatorImpl.*(int, int))",
        throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        String studentName = joinPoint.getSignature().getStudentName();
        System.out.println("The method " +studentName + " occurs exception " + ex);
    }
}
*/
