package FX.Market_Simulator.user;


import java.util.HashMap;
import java.util.Map;

import javax.persistence.*;




@Entity
//the name of the table has to be changed since User is not accepted by apache derby embedded database   
@Table(name = "Users")
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String email;
    @Column
    private String username;
    @Column
    private String password;
    
    @ElementCollection
    @JoinTable(name="Wallet", joinColumns=@JoinColumn(name="user_ID"))
    @MapKeyColumn (name="currency")
    @Column(name="amount")
    private Map<String, Double> Wallet= new HashMap<String, Double>();
 

	public String getUsername() {
		return username;
	}

	public Map<String, Double> getWallet() {
		return Wallet;
	}

	public void setWallet(Map<String, Double> wallet) {
		Wallet = wallet;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
