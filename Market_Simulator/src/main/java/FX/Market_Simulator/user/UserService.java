package FX.Market_Simulator.user;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<?> create(User user);

    User delete(int id);
    
    void deleteAll();
    
    List<User> findAll();

    Optional<User> findById(int id);

    User update(User user, int id);

	ResponseEntity<?> authenticate(User user) throws Exception;

	}
