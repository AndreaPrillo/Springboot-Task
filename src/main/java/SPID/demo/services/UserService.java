package SPID.demo.services;

import SPID.demo.entities.Spid;
import SPID.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import SPID.demo.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser(User user){
        return  userRepository.save(user);
    }
    public User getUser(long userId){
        return  userRepository.getReferenceById(userId);
    }

    public User editUser(long id,User user){
        User userToBeEdited=userRepository.getReferenceById(id);
        if(userToBeEdited==null) return null;
        userToBeEdited=user;
        userToBeEdited.setId(id);
        return userRepository.save(userToBeEdited);
    }

 public Spid searchSpid(long spidid){
  return userRepository.searchSpid(spidid);
 }
}
