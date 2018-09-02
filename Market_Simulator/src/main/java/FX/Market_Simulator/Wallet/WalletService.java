package FX.Market_Simulator.Wallet;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

public interface WalletService {

    ResponseEntity<?> create(Wallet user);

    ResponseEntity<String> delete(int id);
    
    void deleteAll();
    
    List<Wallet> findAll();

    Optional<Wallet> findById(int id);

    Wallet update(Wallet user) throws Exception;



	}
