package FX.Market_Simulator.user;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User create(User user);

    User delete(int id);
    
    void deleteAll();
    
    List<User> findAll();

    Optional<User> findById(int id);

    User update(User user, int id);

	//String search(User user);
}
