package javacode.Goods1_5.main;

import javacode.Goods1_5.main.Person;

public class Manager extends Person {
    public String name;
    private String password;

    public static int PIN=96969696;

    public Manager(String name, String password) {
        this.name=name;
        this.password=password;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public boolean authenticate(String password1){
        return this.password.equals(password1);
    }
}
