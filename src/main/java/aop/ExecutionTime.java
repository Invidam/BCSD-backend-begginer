package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class ExecutionTime
{
    @Pointcut("execution(* controller.HelloController.*(..))")
    public void controllerMethod(){}
    @Pointcut("execution(* controller.*.*(..))")
    public void allMethod(){}

    //    @Around("controllerMethod ()")
//    @Around("controllerMethod () || allMethod()")
    @Around("allMethod()")
    public Object printMethodExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        //AOP가 실행되었음을 알린다.
        System.out.println("Execution Time check");
        try {
            //메소드 실행 이전 시간 기록
            long beforeExecutionTime = System.currentTimeMillis();
            //메소드 실행
            Object ret = pjp.proceed();
            //메소드 실행 이후 시간 기록
            long afterExecutionTime = System.currentTimeMillis();
            //메소드 이름을 출력한다.
            //두 시간 차이를 출력한다.
            System.out.println(pjp.getSignature().getName()  + (afterExecutionTime - beforeExecutionTime));
            return ret;
        }
        catch(Throwable throwable) {
            //예외인 경우 출력하고, 넘긴다.
            System.out.println("At Execution Time, Throwable: " + throwable.getMessage());
            throw throwable;
        }

    }
}
