package Testing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ServletComponentScan
@EnableJpaRepositories

public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    /*
    private static final QuestionService questionService = QuestionServiceImpl.getInstance();

    public static void main(String[] args) throws IOException {
        //questionService.loadFromJSON("src/main/java/Testing/questions.json");
        User user = new User("Tes", "Tess", "test1");
        UserService userService = UserServiceImpl.getInstance();
        //userService.registration(user);
        if (userService.authorization(user)) {
            System.out.println(1);
        } else System.out.println(0);
    }*/
}
