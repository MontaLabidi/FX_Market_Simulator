package FX.Market_Simulator.Currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public Currency create(Currency Currency) {
        return currencyRepository.save(Currency);
    }

    @Override
    public Currency delete(int id) {
    	
        Currency currency = currencyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Currency Not Found !"));
        currencyRepository.deleteById(id);
        return currency;
    }
    
    @Override
    public List<Currency> findAll() {
    	List<Currency> currencies = new ArrayList<>();
    	currencyRepository.findAll().forEach(currencies::add);    	
        return currencies;
    }
    
    @Override
    public void deleteAll() {
         currencyRepository.deleteAll();
         return;
         }
   
    @Override
    public Optional<Currency> findById(int id) {
        return currencyRepository.findById(id);
        
    }

    
}