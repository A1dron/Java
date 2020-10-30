package Testing;

import Testing.entity.Difficulty;
import Testing.entity.Question;
import Testing.entity.TypeQuestion;
import Testing.services.QuestionService;
import Testing.services.QuestionServiceImpl;
import Testing.services.UserService;
import Testing.services.UserServiceImpl;
import Testing.user.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final QuestionService questionService = QuestionServiceImpl.getInstance();

    public static void main(String[] args) throws IOException {
        //questionService.loadFromJSON("src/main/java/Testing/questions");
        User user = new User("Tes", "Tess", "test1");
        UserService userService = UserServiceImpl.getInstance();
        //userService.registration(user);
        if (userService.authorization(user)) {
            System.out.println(1);
        } else System.out.println(0);
    }
}
