package Testing.People;

public abstract class People {
    protected String name;
    protected String login;
    protected String password;

    public People(String name, String login, String password){
        this.name = name;
        this.login = login;
        this.password = password;
    }
}
