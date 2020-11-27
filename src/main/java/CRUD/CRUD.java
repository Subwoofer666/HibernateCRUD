package CRUD;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import javax.persistence.Query;
import java.util.List;


public class CRUD {
    static Configuration configuration = new Configuration().configure();
    static SessionFactory sessionFactory = configuration.buildSessionFactory();
    static Session session = sessionFactory.openSession();


    static void createUser(String name, int age, Tour tour) {
        try {
            session.getTransaction().begin();
            User user = new User();
            user.setName(name);
            user.setAge(age);
            user.setTour(tour);
            session.saveOrUpdate(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    static Tour createTour(String name, String country, String hotel, int days) {
        try {
            session.getTransaction().begin();
            Tour tour = new Tour();
            tour.setName(name);
            tour.setCountry(country);
            tour.setHotel(hotel);
            tour.setNumberOfDays(days);
            session.saveOrUpdate(tour);
            session.getTransaction().commit();
            return tour;
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        return null;
    }

    static void deleteUser (int id) {
        try {
            session.getTransaction().begin();
            User user = session.load(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    static void deleteTour (int id) {
        try {
            session.getTransaction().begin();
            Tour tour = session.load(Tour.class, id);
            session.delete(tour);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }
    
    static User checkUser(String name) {
        User user = new User();
        user.setName(name);
        Query query = session.createNativeQuery("select * from user", User.class);
        List<User> allEntity = query.getResultList();
        if (!allEntity.isEmpty()) {
            for (User x : allEntity) {
                if (name.equals(x.getName())) {
                    user = x;
                }
            }
        }
        return user;
    }
}