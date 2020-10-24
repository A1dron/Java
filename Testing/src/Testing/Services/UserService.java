package Testing.Services;

public interface UserService {


    boolean authorization(String login, String password);

    void registration(String name, String login, String password);

    void logout();
}
