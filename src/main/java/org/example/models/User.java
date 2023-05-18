package org.example.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")//используем Column если имя атрибута класса не совпадаеи с именем столбца в таблице
    private String name;
    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Auto> autos;

    public User(){}

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        autos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void addAuto(Auto auto){
        auto.setUser(this);
        autos.add(auto);
    }

    public void removeAuto(Auto auto){
        autos.remove(auto);
    }
}
