package Testing.services;

import Testing.entity.User;

public interface UserService {


    boolean authorization(User user);

    User registration(User user);

    void logout();
}
