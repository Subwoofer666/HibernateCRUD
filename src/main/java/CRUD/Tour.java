package CRUD;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Entity
@Data
@Table
@SuppressWarnings("All")
public class Tour {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String Country;
    @Column
    private String hotel;
    @Column
    private int numberOfDays;


    @OneToMany
    @JoinColumn(name="tour_id")
    private List<User> user = new ArrayList<>();

    public Tour(String name, String country, String hotel, int numberOfDays) {
        this.name = name;
        Country = country;
        this.hotel = hotel;
        this.numberOfDays = numberOfDays;
    }

    public Tour() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Tour: " +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", Country = '" + Country + '\'' +
                ", hotel = '" + hotel + '\'' +
                ", numberOfDays = " + numberOfDays;
    }
}
