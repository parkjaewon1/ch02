package samp03;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;
public class LogAdvice {
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		String method = pjp.getSignature().getName();
		StopWatch sw = new StopWatch();
		sw.start(method);
		System.out.println("작업 시작 : "+method);
		Object obj = pjp.proceed();
		sw.stop();
		System.out.println("작업종료 : "+sw.getTotalTimeSeconds()+"초");
		return obj;
	}
}