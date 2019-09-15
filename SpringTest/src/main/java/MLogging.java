import org.aspectj.lang.JoinPoint;

import java.util.Arrays;

public class MLogging {
    
    public void init(JoinPoint joinPoint){
        System.out.println("--->Init: "+ 
                Arrays.toString(joinPoint.getArgs()));
    }    
}
