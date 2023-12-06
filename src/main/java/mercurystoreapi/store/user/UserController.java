package mercurystoreapi.store.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "user")
public class UserController {

    private final  UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserClass> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public void registerUser(@RequestBody UserClass user){
        userService.addUser(user);
    }
}