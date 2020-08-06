package bg.softuni.aop.basic;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BasicPointcutSample {
    @Pointcut("execution(* bg.softuni.aop.model.Student.* (..))")
    public void trackSayHello() { }

    @Before("trackSayHello()")
    public void logBeforeMethod() {
        System.out.println("Before executing of say hello!");
    }

    @After("trackSayHello()")
    public void logAfterMethod() {
        System.out.println("After executing of say hello!");
    }
}
