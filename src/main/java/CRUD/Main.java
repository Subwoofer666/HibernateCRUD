package CRUD;

import javafx.application.Application;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.MetadataSource;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import static CRUD.CRUD.*;


public class Main {


    public static void main(String[] args) {
        Tour Russia = createTour("RussiaTour", "Russia", "Moscow", 7);
        Tour USA = createTour("USATour", "USA", "NewYork", 7);
        Tour Canada = createTour("CanadaTour", "Canada", "Toronto", 5);

        createUser("Iren", 22, Russia);
        createUser("Max", 33, Russia);
        createUser("Olia", 45, USA);
        createUser("Justin", 20, Canada);

        System.out.println(checkUser("Justin"));

        sessionFactory.close();

    }
}
