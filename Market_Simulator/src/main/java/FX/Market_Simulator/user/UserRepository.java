package FX.Market_Simulator.user;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

	User findByUsername(String username);
	
	@Query("SELECT u FROM User u WHERE u.username = :username and u.password = :password")
	public List<User> searchuser(@Param("username") String username,@Param("password") String password );
	    
    
}
