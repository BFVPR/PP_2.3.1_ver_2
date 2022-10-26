package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.entity.User;
import web.repository.UserInterface;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserInterface userInterface;

    @Autowired
    public UserService(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public List<User> findAll() {
        return userInterface.findAll();
    }

    public User findById(int id) {
        Optional<User> userOptional =  userInterface.findById(id);
        return userOptional.orElse(null);
    }

    @Transactional
    public void save(User user) {
        userInterface.save(user);
    }

    @Transactional
    public void update(int id, User user) {
        user.setId(id);
        userInterface.save(user);
    }

    @Transactional
    public void deleteById(int id) {
        userInterface.deleteById(id);
    }


}
