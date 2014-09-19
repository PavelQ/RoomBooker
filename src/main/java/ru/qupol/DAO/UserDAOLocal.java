package ru.qupol.DAO;

import ru.qupol.model.User;

import java.util.List;

/**
 * Created by Pavl on 22.04.14.
 */
public interface UserDAOLocal {
    public void addUser(User user);
    public void editUser(User user);
    public void deleteUser(int userId);
    public User getUser(int userId);
    public List<User> getUsers();
}
