package service;

import domain.User;

public interface UserService {
    void createUser(User user);
    User getUserInfo(long id);
    void updateUser(User user);
    void deleteUser(long id);
}
