package aop;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExecutionTime {
    @Around("execution(* controller.HelloController.*(..) )")
    public Object printMethodExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        try {
            System.out.println("Execution Time check");
            long beforeExecutionTime = System.currentTimeMillis();
            Object ret = pjp.proceed();
            long afterExecutionTime = System.currentTimeMillis();
            System.out.println(pjp.getSignature().getName()  + (afterExecutionTime - beforeExecutionTime));
            return ret;
        }
        catch(Throwable throwable) {
            System.out.println("At Execution Time, Throwable: " + throwable.getMessage());
            return null;
        }
    }
}
