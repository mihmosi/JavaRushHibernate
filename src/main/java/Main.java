import model.Auto;
import model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import services.UserServiseImpl;
import util.Util;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, HeuristicRollbackException, SystemException, HeuristicMixedException, RollbackException {
        UserServiseImpl userServise = new UserServiseImpl();

        User user = new User("Masha",26);
        userServise.saveUser(user);
        Auto ferrari = new Auto("Ferrari", "red");
        ferrari.setUser(user);
        user.addAuto(ferrari);
        Auto ford = new Auto("Ford", "black");
        ford.setUser(user);
        user.addAuto(ford);
        userServise.updateUser(user);
//        try {
//            User user = new User("Misha", 51);
//
//            userServise.saveUser(user);
//
//            Auto ferrary = new Auto("Ferrary", "red");
//            ferrary.setUser(user);
//            user.addAuto(ferrary);
//
//            Auto mazda = new Auto("Mazda", "metallic");
//            mazda.setUser(user);
//            user.addAuto(mazda);
//
//            userServise.updateUser(user);
//
//        } catch (HeuristicRollbackException | SystemException | HeuristicMixedException | RollbackException e) {
//            e.printStackTrace();
//        }


//        try (Session session = Util.getSessionFactory().openSession()) {
//            // Check MySQL db version
//            String sql = "select version()";
//
//            String result = (String) session.createNativeQuery(sql).getSingleResult();
//            System.out.println("MySQL db Version is:::");
//            System.out.println(result);
//            session.close();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//        }
    }
}
