package hello.proxy.common.advice;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Slf4j
public class TimeAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("TimePoxy 실행");
        long start = System.currentTimeMillis();

        // target 을 찾아서 실제 객체를 실행시켜줌
        Object result = invocation.proceed();

        long end = System.currentTimeMillis();
        long resultTime = end - start;
        log.info("TimePoxy 종료 resultTime = {}", resultTime);
        return result;
    }
}
