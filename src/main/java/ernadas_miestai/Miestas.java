package ernadas_miestai;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Miestas {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer Id;

    private String pavadinimas;
    
    private String salies_kodas;
    
    private String ikurimo_data;
    
    private int gyventojai;
    
    private double plotas;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getPavadinimas() {
		return pavadinimas;
	}

	public void setPavadinimas(String pavadinimas) {
		this.pavadinimas = pavadinimas;
	}

	public String getSalies_kodas() {
		return salies_kodas;
	}

	public void setSalies_kodas(String salies_kodas) {
		this.salies_kodas = salies_kodas;
	}

	public String getIkurimo_data() {
		return ikurimo_data;
	}

	public void setIkurimo_data(String ikurimo_data) {
		this.ikurimo_data = ikurimo_data;
	}

	public int getGyventojai() {
		return gyventojai;
	}

	public void setGyventojai(int gyventojai) {
		this.gyventojai = gyventojai;
	}

	public double getPlotas() {
		return plotas;
	}

	public void setPlotas(double plotas) {
		this.plotas = plotas;
	}

}
