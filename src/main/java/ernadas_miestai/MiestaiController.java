package ernadas_miestai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MiestaiController {
	
	@Autowired
	private MiestasRepository miestas_repository;	

	
	@RequestMapping(path="/miestai", method={ RequestMethod.GET, RequestMethod.POST })
    public String kreive( Model model) {
		
    	model.addAttribute("miestai", miestas_repository.findAll() );		
		
		return "miestai";
	}
}
