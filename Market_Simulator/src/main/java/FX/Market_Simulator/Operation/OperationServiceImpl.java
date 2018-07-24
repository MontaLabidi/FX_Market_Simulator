package FX.Market_Simulator.Operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FX.Market_Simulator.Currency.Currency;
import FX.Market_Simulator.Currency.CurrencyRepository;
import FX.Market_Simulator.user.User;
import FX.Market_Simulator.user.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import javax.ws.rs.BadRequestException;

@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    private OperationRepository operationRepository;
    

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CurrencyRepository currencyRepository;
    
    @Override
    public Operation create(Operation operation, int user_id, int currency_id) {
    	System.out.println(operation.getOperation());
    	operation.setCurrency(currencyRepository.findById(currency_id).orElseThrow(()
    			-> new EntityNotFoundException("Currency Not Found !")));
    	operation.setUser(userRepository.findById(user_id).orElseThrow(() 
    			-> new EntityNotFoundException("User Not Found !")));
    	operation.setQuote(currencyRepository.findById(currency_id).orElseThrow(()
    			-> new EntityNotFoundException("Currency Not Found !")).getQuote());
    	
    	User user = userRepository.findById(user_id).orElseThrow(()
    			-> new EntityNotFoundException("User Not Found !"));
    	Currency currency = currencyRepository.findById(currency_id).orElseThrow(()
    			-> new EntityNotFoundException("Currency Not Found !"));
    	Map<String, Double> wallet =user.getWallet();
    	if(operation.getOperation().equals("BUY") ) {
	    	if(wallet.containsKey(currency.getBase_currency())) {
		    	
		    		wallet.put(currency.getBase_currency(), wallet.get(currency.getBase_currency())-operation.getAmount());
			    		if(wallet.containsKey(currency.getQuote_currency()))
			    			wallet.put(currency.getQuote_currency(),wallet.get(currency.getQuote_currency())+currency.getQuote()*operation.getAmount());
			    		else 
			    			wallet.put(currency.getQuote_currency(),currency.getQuote()*operation.getAmount());
			    		 return operationRepository.save(operation);
	    		
		    }
	    	else {
	    		
		    			wallet.put(currency.getBase_currency(),-operation.getAmount());
			    		if(wallet.containsKey(currency.getQuote_currency()))
			    			wallet.put(currency.getQuote_currency(),wallet.get(currency.getQuote_currency())+currency.getQuote()*operation.getAmount());
			    		else 
			    			wallet.put(currency.getQuote_currency(),currency.getQuote()*operation.getAmount());
			    		 return operationRepository.save(operation);
			    }
    	}
    	else if(operation.getOperation().equals("SELL")) {//operation is SELL
    		
    	if(wallet.containsKey(currency.getBase_currency())) {
	    	
    		wallet.put(currency.getBase_currency(), wallet.get(currency.getBase_currency())+operation.getAmount());
	    		if(wallet.containsKey(currency.getQuote_currency()))
	    			wallet.put(currency.getQuote_currency(),wallet.get(currency.getQuote_currency())-currency.getQuote()*operation.getAmount());
	    		else 
	    			wallet.put(currency.getQuote_currency(),-currency.getQuote()*operation.getAmount());
	    		 return operationRepository.save(operation);
		
	    }
		else {
			
	    		wallet.put(currency.getBase_currency(),operation.getAmount());
		    		if(wallet.containsKey(currency.getQuote_currency()))
		    			wallet.put(currency.getQuote_currency(),wallet.get(currency.getQuote_currency())-currency.getQuote()*operation.getAmount());
		    		else 
		    			wallet.put(currency.getQuote_currency(),-currency.getQuote()*operation.getAmount());
		    		 return operationRepository.save(operation);
		    }
	    	
	    	}	
    	else {
    		
    		 throw new BadRequestException("Operation cannot be done: Not enough credit");
    	}
       
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
    	List<Operation> operations = new ArrayList<>();
    	operationRepository.findAll().forEach(operations::add);    	
        return operations;
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