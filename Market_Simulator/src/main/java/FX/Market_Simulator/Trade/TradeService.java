package FX.Market_Simulator.Trade;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

public interface TradeService {

	Trade delete(int id);

	List<Trade> findAll();

	Optional<Trade> findById(int id);

	void deleteAll();

	List<Trade> closeTrade(int id);

	ResponseEntity<?> create(Trade trade, int user_id, int currency_id);
	
}
