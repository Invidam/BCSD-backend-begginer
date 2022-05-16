package controller;


import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;
import tools.DateTime;

@RestController
@RequestMapping("/user")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value="create", method = RequestMethod.GET)
    public String createUser() {
        User user = new User();
        user.setAccount("uusseerr");
        user.setPassword("123");
        user.setNickname("uusseerr");
        user.setIsValid(true);

        userService.createUser(user);
        return "createUser";
    }

//    @RequestMapping(value="create", method = RequestMethod.POST)
//    public String createUserProcess() {
//        return "user created";
//    }
    @GetMapping(value="read")
    public User getUserInfo(){
        return userService.getUserInfo(1L);
    }
    @RequestMapping(value="update", method = RequestMethod.GET)
    public String updateUserNickname() {
        User user = new User();
        user.setId(5L);
        user.setNickname("uuuuuuser");

        userService.updateUser(user);
        return "update user";
    }
    @RequestMapping(value="delete", method = RequestMethod.GET)
    public String deleteUser() {
        userService.deleteUser(5L);
        return "delete user";
    }
}

