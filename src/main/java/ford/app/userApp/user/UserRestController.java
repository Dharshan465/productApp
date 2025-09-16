package ford.app.userApp.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/user")
public class UserRestController {


    private final UserService userService;
    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User addNewUser(@RequestBody User user) throws UserException {
        return userService.addNewUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) throws UserNotFoundException {
        return userService.getUserById(id);
    }

    @GetMapping("/allUsers")
    public Collection<User> getAllUsers()throws UserNotFoundException {
        return userService.getAllUser();
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) throws UserNotFoundException, UserException {
        return userService.updateUserDetails(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id) throws UserNotFoundException {
        return userService.deleteUser(id);
    }





}
