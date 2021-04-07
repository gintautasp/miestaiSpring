package ernadas_miestai;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.io.Serializable;

@Entity
public class Salis implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer Id;

    private String salis;	
    
    private String salies_kodas;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getSalis() {
		return salis;
	}

	public void setSalis(String salis) {
		this.salis = salis;
	}

	public String getSalies_kodas() {
		return salies_kodas;
	}

	public void setSalies_kodas(String salies_kodas) {
		this.salies_kodas = salies_kodas;
	}    
    
    
}
