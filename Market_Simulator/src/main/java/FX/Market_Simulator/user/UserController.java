package FX.Market_Simulator.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@EnableAutoConfiguration
@RestController
@RequestMapping({"/api"})
public class UserController {
	
	@Autowired
    private UserService userService;   
    
    @PostMapping(path ={"/"})
    public ResponseEntity<?> create(@RequestBody User user){
    	return userService.create(user);
    	}
    
    @PostMapping(path = {"/authenticate"})
    public ResponseEntity<?> authenticate (@RequestBody User user) throws Exception {
    	return userService.authenticate(user);
    }   
    @GetMapping(path = {"/{id}"})
    public Optional<User> findById(@PathVariable("id") int id){
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
