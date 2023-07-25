package javacode.Goods1_5.main;

public class Person {
    public String name;
    private String password;

    public Person(String name,String password){
        this.name=name;
        this.password=password;
    }
    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
