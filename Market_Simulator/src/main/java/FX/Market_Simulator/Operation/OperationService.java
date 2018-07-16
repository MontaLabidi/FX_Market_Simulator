package FX.Market_Simulator.Operation;

import java.util.List;
import java.util.Optional;

public interface OperationService {

	Operation create(Operation Operation);

	Operation delete(int id);

	List<Operation> findAll();

	Optional<Operation> findById(int id);

	List<Operation> findByUserId(int userid);

	void deleteAll();

	void deleteAllByUser(List<Operation> entities);

	
	
	
}
