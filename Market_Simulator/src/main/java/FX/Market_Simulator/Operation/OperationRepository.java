package FX.Market_Simulator.Operation;


import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface OperationRepository extends CrudRepository<Operation, Integer> {

	public List<Operation> findByUserId(int userid);
	
	
    
}
