package examples.csvIO.securityCheck.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CountAspect {

    public static int counter = 0;

    @Pointcut("@annotation(Countable)")
    public void executeCounting() {}

    @Before(value = "executeCounting()")
    public void countMethodCall(JoinPoint joinPoint) {
        System.out.println(++counter + ": "
                + joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName());
    }
}
