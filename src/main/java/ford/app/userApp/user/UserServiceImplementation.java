package ford.app.userApp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;
    @Autowired
    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User addNewUser(User user) throws UserException {
        if(validateUserData(user).equals("Valid")){
            if(userRepository.existsById(user.getUserId())){
                throw new UserException("User with id "+user.getUserId()+" already exists");
            }
            return userRepository.save(user);
        }else {
            throw new UserException("Invalid User Data : " + validateUserData(user));
        }
    }

    @Override
    public User getUserById(Integer id) throws UserNotFoundException {
        if(userRepository.existsById(id)){
            return userRepository.findById(id).get();
        }else{
            throw new UserNotFoundException("User with id "+id+" not found");
        }
    }

    @Override
    public Collection<User> getAllUser() throws UserNotFoundException {
    Collection<User> users = userRepository.findAll();
    if(users.isEmpty()){
        throw new UserNotFoundException("No Users Found in the Database");
    }
    return users;
    }

    @Override
    public User updateUserDetails(User user) throws UserException, UserNotFoundException {
        if(validateUserData(user).equals("Valid")){
            if(userRepository.existsById(user.getUserId())){
                return userRepository.save(user);
            }else{
                throw new UserNotFoundException("User with id "+user.getUserId()+" not found");
            }
        }else {
            throw new UserException("Invalid User Data : " + validateUserData(user));
        }
    }

    @Override
    public String deleteUser(Integer id) throws UserNotFoundException {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return "User with id "+id+" deleted successfully";
        }else{
            throw new UserNotFoundException("User with id "+id+" not found");
        }
    }

    @Override
    public String validateUserData(User user) throws UserException {
        if(user.getUserName() == null || user.getUserName().isEmpty()){
            return "User Name is missing";
        }else if(user.getPassword() == null || user.getPassword().isEmpty()){
            return "Password is missing";
        }else if(user.getEmail() == null || user.getEmail().isEmpty()){
            return "Email is missing";
        }else if(user.getRole() == null || user.getRole().equals("")){
            return "Role is missing";
        }else if (user.getDateOfBirth() == null || user.getDateOfBirth().equals("")){
            return "Date of Birth is missing";
        }else if (user.getUserId() == null || user.getUserId().equals("")){
            return "User ID is missing";
        }else{
            return "Valid";
        }
    }
}
