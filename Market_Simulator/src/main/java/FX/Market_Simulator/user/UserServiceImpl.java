package FX.Market_Simulator.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    public User delete(int id) {
    	
        User user = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("User Not Found !"));
        repository.deleteById(id);
        return user;
    }

    @Override
    public List<User> findAll() {
    	List<User> users = new ArrayList<>();
    	repository.findAll().forEach(users::add);    	
        return users;
    }
    
     
    public void deleteAll() {
         repository.deleteAll();
         return;
         }
  
    @Override
    public Optional<User> findById(int id) {
        return repository.findById(id);
        
    }

    @Override
    public User update(User user, int id) {
    	Optional<User> DB_user = findById(id);
        if(DB_user.isPresent()){
            repository.delete(user);
        }
        return repository.save(user); 
        }
}