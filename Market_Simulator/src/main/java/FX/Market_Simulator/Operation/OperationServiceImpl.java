package FX.Market_Simulator.Operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;

@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    private OperationRepository operationRepository;

    @Override
    public Operation create(Operation Operation) {
        return operationRepository.save(Operation);
    }

    @Override
    public Operation delete(int id) {
    	
        Operation Operation = operationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Operation Not Found !"));
        operationRepository.deleteById(id);
        return Operation;
    }
    @Override
    public List<Operation> findByUserId(int userid) {
    	return operationRepository.findByUserId(userid);
    }

    @Override
    public List<Operation> findAll() {
    	List<Operation> users = new ArrayList<>();
    	operationRepository.findAll().forEach(users::add);    	
        return users;
    }
    
    @Override
    public void deleteAll() {
         operationRepository.deleteAll();
         return;
         }
    @Override
    public void deleteAllByUser(List<Operation>  entities) {
        operationRepository.deleteAll(entities);
        return;
        }
    
    @Override
    public Optional<Operation> findById(int id) {
        return operationRepository.findById(id);
        
    }

    
}