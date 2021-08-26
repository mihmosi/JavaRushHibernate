package model;

import javax.persistence.*;

@Entity
// ТАК НАЗЫВАЕТСЯ ТАБЛИЦА
@Table(name = "autos")
public class Auto {
    // это указание, что поле является идентификатором объектов этого класса
    @Id
    /*Аннотация @GeneratedValue используется для указания способа создания первичного ключа.

     стратегию Identity, которая Указывает, что поставщик сохраняемости
     должен назначить первичные ключи для сущности,
 используя столбец идентификатора базы данных.*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /* если имя поля в классе и таблице совпадает
       — можно не добавлять аннотацию @Column, будет работать и так.*/
    @Column(name = "model")
    private String model;
    //можно не указывать Column name, если оно совпадает с названием столбца в таблице
    private String color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Auto() {

    }

    public Auto(String model, String color) {
        this.model = model;
        this.color = color;
    }

    public int getId() {
        return id;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return color + " " + model;
    }
}
