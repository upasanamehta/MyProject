package expedia.http;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;
import java.util.Properties;

/**
 * Created by umehta on 6/23/16.
 */

@RestController
public class Ping {

    final static String hello = "hello";

    @RequestMapping(value = "/ping" , method = RequestMethod.GET )
    public @ResponseBody String ping() throws IOException {
        final Properties properties = new Properties();
        properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
        String projectVersion = properties.getProperty("version");

        //System.out.println(projectVersion);
        return "pong \nProject Version : " + projectVersion +"\n";

    }

}
