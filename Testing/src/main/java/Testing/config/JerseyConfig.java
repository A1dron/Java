package Testing.config;

import Testing.controller.QuestionRest;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig(){
        register(QuestionRest.class);
    }
}
