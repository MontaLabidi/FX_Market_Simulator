package FX.Market_Simulator.Currency;

import java.util.List;
import java.util.Optional;

public interface CurrencyService {

	Currency create(Currency Currency);

	Currency delete(int id);

	List<Currency> findAll();

	Optional<Currency> findById(int id);

	void deleteAll();
	
}
