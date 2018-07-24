package FX.Market_Simulator.user;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<?> create(User user);

    ResponseEntity<String> delete(int id);
    
    void deleteAll();
    
    List<User> findAll();

    Optional<User> findById(int id);

    User update(User user) throws Exception;

	ResponseEntity<?> authenticate(User user) throws Exception;

	Map<String, Double> wallet(int id);

	String wallet_currency(int id, String currency_id);

	}
