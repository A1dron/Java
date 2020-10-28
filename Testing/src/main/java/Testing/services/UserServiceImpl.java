package Testing.services;

public class UserServiceImpl implements UserService {
    @Override
    public boolean authorization(String login, String password) {
        return false;
    }

    @Override
    public void registration(String name, String login, String password) {

    }

    @Override
    public void logout() {

    }
}
