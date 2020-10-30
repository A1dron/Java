package Testing.services;

public class UserServiceImpl implements UserService {

    private static UserServiceImpl instance;

    private UserServiceImpl(){

    }

    public static UserServiceImpl getInstance(){
        if (instance == null){
            instance = new UserServiceImpl();
        }
        return instance;
    }

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
