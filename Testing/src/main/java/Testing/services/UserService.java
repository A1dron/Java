package Testing.services;

import Testing.entity.User;

public interface UserService {


    boolean authorization(User user);

    void registration(User user);

    void logout();
}
