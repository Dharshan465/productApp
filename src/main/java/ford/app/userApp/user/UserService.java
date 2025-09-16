package ford.app.userApp.user;

import java.util.Collection;

public interface UserService {

    User addNewUser(User user) throws UserException;

    User getUserById(Integer id) throws UserNotFoundException;

    Collection<User> getAllUser() throws UserNotFoundException;

    User updateUserDetails(User user) throws UserException,UserNotFoundException;

    String deleteUser(Integer id) throws UserNotFoundException;

    String validateUserData(User user)throws UserException;

}
