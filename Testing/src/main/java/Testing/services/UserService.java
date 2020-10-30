package Testing.services;

import Testing.user.User;

public interface UserService {


    boolean authorization(User user);

    void registration(User user);

    void logout();
}
