package ernadas_miestai;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MiestaiController {
	
	@Autowired
	private MiestasRepository miestas_repository;	

	
	@RequestMapping(path="/miestai", method={ RequestMethod.GET, RequestMethod.POST })
    public String miestai(@RequestParam(name="id", required=false, defaultValue="0") Integer id 
			, @RequestParam(name="pav", required=false, defaultValue="") String pav
			, @RequestParam(name="salies_kodas", required=false, defaultValue="") String salies_kodas
			, @RequestParam(name="ikurimo_data", required=false, defaultValue="") String ikurimo_data
			, @RequestParam(name="gyventojai", required=false, defaultValue="0") String gyventojai
			, @RequestParam(name="plotas", required=false, defaultValue="0.0") String plotas
			, @RequestParam(name="saugoti", required=false, defaultValue="nesaugoti") String saugoti			
			, Model model) {
		
		String res = "Neatlikta";
		
		Miestas miestas = new Miestas();
		
		if ( saugoti.equals( "saugoti" ) ) {
		
			if (id > 0) {
				
				Optional <Miestas> found = miestas_repository.findById( id );
			
				// variantas trynimuiui
				// uzsakymaiRepository.deleteById(id);
			
				if ( found.isPresent() ) {
				
				   miestas = found.get();
				   miestas.setId ( id );
				   
				} else {
					
					res = "Klaida įrašas galėjoi būti pašalintas";
				}
			}	
			
		    miestas.setPavadinimas( pav );
		    miestas.setSalies_kodas(salies_kodas);
		    miestas.setIkurimo_data(ikurimo_data);
		    miestas.setGyventojai ( Integer.parseInt ( gyventojai ) );
		    miestas.setPlotas( Double.parseDouble ( plotas ) );
		  
		    miestas_repository.save ( miestas );
		    res = "Saugota";
		    
		}
    	model.addAttribute("miestai", miestas_repository.findAll() );
    	model.addAttribute("res", res );		
   
		return "miestai";	
	}	
	
	@RequestMapping(path="/miestas")	
	public @ResponseBody Miestas miestoDuom(@RequestParam(name="id", required=true, defaultValue="0") Integer id ) throws IOException {
		
		String res;
		
		Miestas miestas = new Miestas();
		
		if (id > 0) {
			
			Optional <Miestas> found = miestas_repository.findById( id );
		
			// variantas trynimuiui
			// uzsakymaiRepository.deleteById(id);
		
			if ( found.isPresent() ) {
			
			   miestas = found.get();
			   miestas.setId ( id );
			   
			} else {
				
				res = "Klaida įrašas galėjoi būti pašalintas";
			}
		}		
		
		return miestas;
	}
	
	/*
	@GetMapping(path="/salinti-tiekeja") // Map ONLY GET Requests
	public @ResponseBody String salintiTiekeja (@RequestParam Integer id 
			) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		
		Optional <Tiekejai> found = tiekejaiRepository.findById( id );
		
		String res = "Not done";
		
		if ( found.isPresent() ) {
			
			   Tiekejai n = found.get();
			   tiekejaiRepository.deleteById(id);
			   res = "Deleted";
		}		
		return res;
	}
	*/	
}
