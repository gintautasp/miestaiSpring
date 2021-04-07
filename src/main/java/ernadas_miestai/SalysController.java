package ernadas_miestai;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SalysController {

	
	@Autowired
	private SalisRepository salis_repository;	

	
	@RequestMapping(path="/salys", method={ RequestMethod.GET, RequestMethod.POST })
    public String miestai(@RequestParam(name="id", required=false, defaultValue="0") Integer id 
			, @RequestParam(name="pav", required=false, defaultValue="") String pav
			, @RequestParam(name="salies_kodas", required=false, defaultValue="") String salies_kodas	
			, @RequestParam(name="saugoti", required=false, defaultValue="nesaugoti") String saugoti			
			, Model model) {
		
		String res = "Neatlikta";
		
		Salis salis = new Salis();
		
		if ( saugoti.equals( "saugoti" ) ) {
		
			if (id > 0) {
				
				Optional <Salis> found = salis_repository.findById( id );
			
				// variantas trynimuiui
				// uzsakymaiRepository.deleteById(id);
			
				if ( found.isPresent() ) {
				
				   salis = found.get();
				   salis.setId ( id );
				   
				} else {
					
					res = "Klaida įrašas galėjoi būti pašalintas";
				}
			}	
			
		    salis.setSalis( pav );
		    salis.setSalies_kodas(salies_kodas);

		  
		    salis_repository.save ( salis );
		    res = "Saugota";
		    
		}
    	model.addAttribute("salys", salis_repository.findAll() );
    	model.addAttribute("res", res );		
   
		return "salys";	
	}		
}
