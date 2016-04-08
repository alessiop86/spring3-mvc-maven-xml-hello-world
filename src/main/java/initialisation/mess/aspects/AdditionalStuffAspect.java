package initialisation.mess.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import initialisation.mess.annotations.DoAdditionalStuff;
import initialisation.mess.service.AdditionalStuffService;

@Aspect
public class AdditionalStuffAspect {

    private AdditionalStuffService service;

    public AdditionalStuffService getService() {
        return service;
    }

    public void setService(AdditionalStuffService service) {
        this.service = service;
    }

    @Pointcut(value="execution(public * *(..))")
    private void anyPublicMethod() { }

    @AfterReturning("anyPublicMethod() && @annotation(doAdditionalStuff)")
    public void afterReturning(JoinPoint jointPoint, DoAdditionalStuff doAdditionalStuff) {
        System.out.println(jointPoint);
        service.doStuff();
    }
}
