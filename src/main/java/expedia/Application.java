package expedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.Arrays;

/**
 * Created by umehta on 6/23/16.
 */

@SpringBootApplication
public class Application {

    public static void main (String args[]){
        ApplicationContext context = SpringApplication.run(Application.class , args);
        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String [] beans = context.getBeanDefinitionNames();
        Arrays.sort(beans);
        for (String beanName : beans) {
            System.out.println(beanName);
        }
        
        

    }
}
