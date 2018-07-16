package FX.Market_Simulator.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)

@EnableAutoConfiguration
@RestController
@RequestMapping({"/api"})
public class UserController {
	
	@Autowired
    private UserService userService;
    @Autowired
    private UserRepository repository;
   
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @PostMapping(path ={"/"})
    public ResponseEntity<?> create(@RequestBody User user){
    	if(repository.findByUsername(user.getUsername()) == null) {
    		user.setPassword(passwordEncoder.encode(user.getPassword()));
        	userService.create(user);
        	return new ResponseEntity<>(HttpStatus.OK);
        			}
    	return new ResponseEntity<String>("{\"message\": \"Username already used\"}",HttpStatus.NOT_ACCEPTABLE);
    }
    
    /*@ResponseBody
    public ResponseEntity sendViaResponseEntity() {
        return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
    }*/
    
    @PostMapping(path = {"/authenticate"})
    public ResponseEntity<?> search (@RequestBody User user) throws Exception{
    	if(repository.findByUsername(user.getUsername()) == null)
    		throw new EntityNotFoundException("Username Not Found");
    	User DB_user = repository.findByUsername(user.getUsername());
		if (passwordEncoder.matches(user.getPassword(),
				repository.findByUsername(user.getUsername()).getPassword())) { 
			 String res= "{\"id\": "+DB_user.getId()+","
						+ "\"firstName\": \""+DB_user.getFirstName().toString()+"\","
						+ "\"lastName\": \""+DB_user.getLastName().toString()+"\","
						+ "\"email\": \""+DB_user.getEmail().toString()+"\","
						+ "\"username\": \""+DB_user.getUsername().toString()+"\","
						+ "\"password\": \""+DB_user.getPassword().toString()+"\""
						//+ ",\"token\": \"jwt-token\""
						+ "}";
			 return new ResponseEntity<>(res, HttpStatus.OK);
		}
		
		 throw new AccessDeniedException("password is incorrect"); 
		

    	//return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
    }   
    @GetMapping(path = {"/{id}"})
    public Optional<User> findOne(@PathVariable("id") int id){
        return userService.findById(id);
    }

    @PutMapping(path = {"/{id}"})
    public User update(@RequestBody User user, @PathVariable("id") int id){
        return userService.update(user, id);
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
       User user = userService.delete(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @DeleteMapping(path ={"/"})
    public void deleteAll() {
         userService.deleteAll();
         return ;
    }

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }
}
