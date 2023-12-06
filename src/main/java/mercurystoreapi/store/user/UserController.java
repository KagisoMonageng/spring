package mercurystoreapi.store.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

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
    @GetMapping("/{id}")
    public Optional<UserClass> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public ResponseEntity registerUser(@RequestBody UserClass user){
        return userService.addUser(user);
    }

    @DeleteMapping(params = "/{id}")
    public ResponseEntity deleteAccount(@PathVariable("id") Long id){
        return userService.deleteAccount(id);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updateUser(@PathVariable Long id, @RequestBody UserClass updatedUser) {
       return userService.updateAccount(id,updatedUser);
    }
        
}