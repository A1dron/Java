package Testing.user;

import Testing.entity.Role;

public class User {
    private String name;
    private String login;
    private String password;
    private Role role;

    public User(String name, String login, String password){
        this.name = name;
        this.login = login;
        this.password = password;
    }
}
