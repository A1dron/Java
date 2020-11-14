package Testing.services;

import Testing.entity.User;

public interface UserService {


    boolean authorization(User user) throws Exception;

    void registration(User user) throws Exception;

    void logout();
}
