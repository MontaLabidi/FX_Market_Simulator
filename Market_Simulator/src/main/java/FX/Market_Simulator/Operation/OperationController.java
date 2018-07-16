package FX.Market_Simulator.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityNotFoundException;
import javax.ws.rs.BadRequestException;

import FX.Market_Simulator.user.UserService;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)

@EnableAutoConfiguration
@RestController
@RequestMapping({"/api"})
public class OperationController {
	
	@Autowired
    private OperationService operationService;
	   
	@Autowired
    private UserService userService;
	
	
    @PostMapping(path = {"/user/{user_id}/operation"})
    public Operation create(@RequestBody Operation operation,@PathVariable("user_id") int user_id){
    	operation.setUser(userService.findById(user_id).orElseThrow(() -> new EntityNotFoundException("User Not Found !")));
    	
        return	operationService.create(operation);
  
    }
    
    @GetMapping(path = {"user/{user_id}/operation/{id}"})
    public Operation findById(@PathVariable("id") int id, @PathVariable("user_id") int user_id) throws Exception{
    	userService.findById(user_id).orElseThrow(() -> new EntityNotFoundException("User Not Found !"));
    	Operation operation=operationService.findById(id).orElseThrow(() -> new EntityNotFoundException("Operation Not Found !"));
    	if(operation.getUser().getId()!=user_id)
    		throw new BadRequestException("Bad request !");
    	return operation;
    }
    @GetMapping(path = {"user/{user_id}/operation"})
    public List<Operation> findByUserId(@PathVariable("user_id") int user_id){
        return operationService.findByUserId(user_id);
    }
   
    @DeleteMapping(path = {"user/{user_id}/operation/{id}"})
    public Operation delete(@PathVariable("id") int id, @PathVariable("user_id") int user_id) {
    	userService.findById(user_id).orElseThrow(() -> new EntityNotFoundException("User Not Found !"));
    	Operation operation=operationService.findById(id).orElseThrow(() -> new EntityNotFoundException("Operation Not Found !"));
    	if(operation.getUser().getId()!=user_id)
    		throw new BadRequestException("Bad request !");
       
        return operationService.delete(id);
    }
    @DeleteMapping(path = {"user/{user_id}/operation"})
    public ResponseEntity<?> deleteAllByUser(@PathVariable("user_id") int user_id) {
    	List<Operation> operations =operationService.findByUserId(user_id);
         operationService.deleteAllByUser(operations);
         return new ResponseEntity<>(operations,HttpStatus.OK); 
    }

    @GetMapping(path = {"/operation"})
    public List<Operation> findAll(){
        return operationService.findAll();
    }
}
