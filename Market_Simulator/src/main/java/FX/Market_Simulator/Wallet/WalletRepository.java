package FX.Market_Simulator.Wallet;



import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import FX.Market_Simulator.user.User;

public interface WalletRepository extends CrudRepository<Wallet, Integer> {
	
	public Optional<Wallet> findByuser(User user);
	

}
