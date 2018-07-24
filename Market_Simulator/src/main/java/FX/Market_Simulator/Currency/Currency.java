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
	
	private String base_currency ; //example EUR
	
	private String quote_currency;//example USD
	
    private double quote; // USD/EUR quote of .91 means that you’ll receive 0.91 euros for every US dollar you sell
    
    private double volume;
    
    private double day_High;
    
    private double day_low;
    
    
	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getDay_High() {
		return day_High;
	}

	public void setDay_High(double day_High) {
		this.day_High = day_High;
	}

	public double getDay_low() {
		return day_low;
	}

	public void setDay_low(double day_low) {
		this.day_low = day_low;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getQuote() {
		return quote;
	}

	public String getBase_currency() {
		return base_currency;
	}

	public void setBase_currency(String base_currency) {
		this.base_currency = base_currency;
	}

	public String getQuote_currency() {
		return quote_currency;
	}

	public void setQuote_currency(String quote_currency) {
		this.quote_currency = quote_currency;
	}

	public void setQuote(double quote) {
		this.quote = quote;
	}
    
    
}
