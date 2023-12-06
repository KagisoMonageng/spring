package mercurystoreapi.store.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<UserClass> getUsers() {
        if (userRepo.findAll().size() <= 0) {
            throw new IllegalStateException("No users found");
        }
        return userRepo.findAll();
    }

    public ResponseEntity addUser(UserClass user) {
        Optional<UserClass> userByEmail = userRepo.getUserByEmail(user.getEmail());
        if (userByEmail.isPresent()) {
            throw new IllegalStateException("User already exists");
        } else if (userRepo.save(user) != null) {
            return new ResponseEntity<>("User added successfully", HttpStatus.OK);
        } else {
            throw new IllegalStateException("Failed to save user");
        }
    }

    public ResponseEntity deleteAccount(Long id) {
        Optional<UserClass> user = userRepo.findById(id);
        userRepo.deleteById(id);
        return new ResponseEntity<>(user.get().getName() + "'s Account deleted", HttpStatus.OK);
    }

    public ResponseEntity updateAccount(Long id, UserClass user) {
        Optional<UserClass> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()) {
            UserClass existingUser = optionalUser.get();

            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());

            userRepo.save(existingUser);

            String successMessage = "User updated successfully";
            return ResponseEntity.ok(successMessage);
        } else {
            String errorMessage = "User not found with id: " + id;
            return ResponseEntity.status(404).body(errorMessage);
        }
    }

    public Optional<UserClass> getUserById(Long id) {
        if (userRepo.existsById(id)) {
            throw new IllegalStateException("No user found with that id");
        }
        Optional<UserClass> userOptional = userRepo.findById(id);
        return userOptional;
    }
}
