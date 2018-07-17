package FX.Market_Simulator.Currency;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity   
@Table
public class Currency {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String currency ; //example USD/EUR
    
    private float quote; // USD/EUR quote of .91 means that you’ll receive 0.91 euros for every US dollar you sell

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public float getQuote() {
		return quote;
	}

	public void setQuote(float quote) {
		this.quote = quote;
	}
    
    
}
