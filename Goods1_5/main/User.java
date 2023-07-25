package javacode.Goods1_5.main;

public class User extends Person {
    public String name;
    private String pone;
    private String password;

    public User() {
        super();
    }

    public User(String name,String password){
        this.name=name;
        this.password=password;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public boolean authenticate(String password1){
        return this.password.equals(password1);
    }
}
