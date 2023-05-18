package sk.stuba.fei.oop.cvicenie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public String sendPozdrav(String name){
        return "Cau " + name;
    }

    public User sendPozdravObjekt(String name){
        User user = new User();
        user.setName(name);
        userRepo.save(user);
        return user;
    }

    public boolean sendPozdravObjektGet(Long id){
       Optional<User> users =  userRepo.findById(id);

        return users.isEmpty();
    }
}
