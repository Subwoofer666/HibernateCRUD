package CRUD;


import javax.persistence.*;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private int age;

    @ManyToOne
    private Tour tour;



    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public User() {
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
    public Tour getTour() {
        return tour;
    }
    public void setTour(Tour tour) {
        this.tour = tour;
    }
    @Override
    public String toString() {
        return "User " +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", age = " + age +
                ", tour = " + tour;
    }
}

