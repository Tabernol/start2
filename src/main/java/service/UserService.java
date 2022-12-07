package service;

import dao.UserDao;
import model.User;

public class UserService {
    UserDao userDao = new UserDao();

    public long getId(String login) {
        return userDao.getId(login);
    }

    public boolean isCorrectPassword(long id, String password) {
        User user = userDao.get(id);
        return password.equals(user.getPassword());
    }

    public String getRoleById(long id){
        User user = userDao.get(id);
        return user.getRole();
    }
}
