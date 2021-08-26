package services;
import dao.UserDao;
import dao.UserDaoIml;
import model.Auto;
import model.User;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import java.util.List;

public class UserServiseImpl {
    private final UserDaoIml usersDao = new UserDaoIml();

    public UserServiseImpl() {
    }

    public User findUser(int id) {
        return usersDao.findById(id);
    }

    public void saveUser(User user) {
        usersDao.save(user);
    }

    public void deleteUser(User user) {
        usersDao.delete(user);
    }

    public void updateUser(User user) throws HeuristicRollbackException, SystemException, HeuristicMixedException, RollbackException {
        usersDao.update(user);
    }

    public List<User> findAllUsers() {
        return usersDao.findAll();
    }

    public Auto findAutoById(int id) {
        return usersDao.findAutoById(id);
    }
}
