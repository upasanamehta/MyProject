package expedia;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

/**
 * Created by umehta on 6/23/16.
 */

@SpringBootApplication
public class Application {

//    @Autowired
//    private Environment environment;

    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger("myLogger");

    //private static final String[] validProfiles = {"prod", "qa", "int", "dev"};

    public static void main (String args[]) throws Exception{
        ApplicationContext context = SpringApplication.run(Application.class , args);

       /* String profile = getProfile(context.getEnvironment());
        if(profile == null) {
            throw new Exception();
        } */
        logger.debug("Started the spring boot application in debug");
        logger.info("Started the spring boot application");

        //System.out.println("Project startup success : profile= " +profile);
        //log.info("Capture startup success: profile={}", profile);
        //  System.out.println("Let's inspect the beans provided by Spring Boot:");

        String [] beans = context.getBeanDefinitionNames();
        Arrays.sort(beans);
        for (String beanName : beans) {
            System.out.println(beanName);
        }




    }

    /*private static String getProfile(Environment environment) {
        if(environment == null) {
            return null;
        }
        String[] activeProfiles = environment.getActiveProfiles();
        if(activeProfiles == null || activeProfiles.length > 1) {
            return null;
        }
        String profile = activeProfiles[0];
        for(String s : validProfiles) {
            if(s.equals(profile)) {
                return profile;
            }
        }
        return null;
    } */
}
