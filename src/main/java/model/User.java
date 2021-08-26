package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// АнноТАЦИЯЯ ENtity
/*Чтобы класс мог быть сущностью, к нему предъявляются следующие требования:
Должен иметь пустой конструктор (public или protected); +++++
Не может быть вложенным, интерфейсом или enum;
Не может быть final и не может содержать final-полей/свойств;
Должен содержать хотя бы одно @Id-поле.*/
@Entity
@Table(name = "users")
// НЕ FINALE !!!!!!!!!!!!===========
public class User {
    // ID  ПОЛЕ !!!!!!!!!===================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    // @ не казываю так как совпадает с названием cтолбца в таблице
    private int age;
    // OneToMany  это связь оного со многими Настройка "mappedBY" указывает на поле user класса Auto
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    // Настройка orphanRemoval вполне хорошо переводится с английского — "удалять сирот".
    private List<Auto> autos;

    // ПУСТОЙ === КОНСТРУКТОР  ===============================
    public User() {

    }

    // КОНСТРУКТОР===============================
    public User(String name, int age) {
        this.name = name;
        this.age = age;
        autos = new ArrayList<>();
    }
// Добавляем автомобили для Юзера в список
    public void addAuto(Auto auto) {
        auto.setUser(this); // объекту авто назнааем юзера
        autos.add(auto);  // доюавляем в список автомобили
    }

    public void removeAuto(Auto auto) {
        autos.remove(auto);
    }

    public int getId() {
        return id;
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

    public List<Auto> getAutos() {
        return autos;
    }

    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }

    @Override
    public String toString() {
        return "models.User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    /*При этом entity может:
Содержать непустые конструкторы;
Наследоваться и быть наследованным;
Содержать другие методы и реализовывать интерфейсы.*/
}
