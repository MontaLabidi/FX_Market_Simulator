package FX.Market_Simulator.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public ResponseEntity<?> create(User user){
    	if(userRepository.findByUsername(user.getUsername()) == null) {
    		user.setPassword(passwordEncoder.encode(user.getPassword()));
        	userRepository.save(user);
        	return new ResponseEntity<>(HttpStatus.OK);
        			}
    	return new ResponseEntity<String>("{\"message\": \"Username already used\"}",HttpStatus.NOT_ACCEPTABLE);
    }
    
    @Override
    public ResponseEntity<?> authenticate (User user) throws Exception{
    	if(userRepository.findByUsername(user.getUsername()) == null)
    		throw new EntityNotFoundException("Username Not Found");
    	
    	User DB_user = userRepository.findByUsername(user.getUsername());
		if (passwordEncoder.matches(user.getPassword(),
				DB_user.getPassword())) { 
			 
			 return new ResponseEntity<>(DB_user, HttpStatus.OK);
		}
		
		 throw new AccessDeniedException("password is incorrect"); 
		
    }   


    @Override
    public User delete(int id) {
    	
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User Not Found !"));
        userRepository.deleteById(id);
        return user;
    }

    @Override
    public List<User> findAll() {
    	List<User> users = new ArrayList<>();
    	userRepository.findAll().forEach(users::add);    	
        return users;
    }
    
    @Override
    public void deleteAll() {
         userRepository.deleteAll();
         return;
         }
  
    @Override
    public Optional<User> findById(int id) {
        return userRepository.findById(id);
        
    }

    @Override
    public User update(User user, int id) {
    	Optional<User> DB_user = findById(id);
        if(DB_user.isPresent()){
            userRepository.delete(user);
        }
        return userRepository.save(user); 
        }
}