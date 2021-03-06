package service;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserMapper;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public void createUser(User user) {
        userMapper.createUser(user);
    }
    @Override
    public User getUserInfo(long id) {
        User user = userMapper.getUserById(id);
        user.setId(id);
        return user;
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUserNicknameById(user);
    }

    @Override
    public void deleteUser(long id) {
        userMapper.deleteUserById(id);
    }
}