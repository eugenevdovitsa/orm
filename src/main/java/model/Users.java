package model;

import annotation.*;

@EntitySoft
@TableSoft (name = "users")
public class Users {

    @IdSoft
    @GeneratedValueSoft
    private int id;

    @ColumnSoft()
    private String name;

    @ColumnSoft(name = "age")
    //@ExcludeSoft
    private int age;

    @ColumnSoft(name = "city")
    private String city;

    public Users() {
    }

    public Users(String name) {
        this.name = name;
    }

    public Users(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }
}
