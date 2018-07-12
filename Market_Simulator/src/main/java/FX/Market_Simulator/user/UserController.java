package FX.Market_Simulator.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/api"})
public class UserController {

    @Autowired
    private UserService userService;
   
    @PostMapping(path ={"/"})
    public User create(@RequestBody User user){
        return userService.create(user);
    }
    
    @PostMapping(path = {"/authenticate"})
    public User search (@RequestBody User user){
    	return userService.search(user);
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
    public User delete(@PathVariable("id") int id) {
        return userService.delete(id);
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
