import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {    
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        MService s = (MService) context.getBean("service");
        System.out.println(s.getIntVal(11));
    }
}
