package FX.Market_Simulator.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

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
        Optional<User> user = findById(id);
        if(user.isPresent()){
            repository.deleteById(user.get().getId());
        }
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    @Override
    public List<User> findAll() {
    	List<User> users = new ArrayList<>();
    	repository.findAll().forEach(users::add);    	
        return users;
    }
    
  public User search (User user){
    	List<User> users = repository.searchuser(user.getUsername(),user.getPassword());
    	return users.get(0);
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
    	Optional<User> user1 = findById(id);
        if(user1.isPresent()){
            repository.delete(user);
        }
        return repository.save(user); 
        }
}