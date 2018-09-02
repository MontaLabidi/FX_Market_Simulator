package FX.Market_Simulator.user;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import FX.Market_Simulator.Trade.Trade;
import FX.Market_Simulator.Wallet.Wallet;

public interface UserService {

    ResponseEntity<?> create(User user);

    ResponseEntity<String> delete(int id);
    
    void deleteAll();
    
    List<User> findAll();

    Optional<User> findById(int id);

    User update(User user) throws Exception;

	ResponseEntity<?> authenticate(User user) throws Exception;

	Wallet wallet(int id);

	List<Trade> trades(int id);


	}
