package consommi.tounsi.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import consommi.tounsi.entity.Reclamation;
import consommi.tounsi.repository.ReclamationRepository;
import consommi.tounsi.service.ReclamationService;

@RequestMapping("/reclamation")
@RestController
@CrossOrigin
public class ReclamationRestControl {
	
	//Weak Linking
	@Autowired
	ReclamationService reclamationService;
	
	@Autowired
	ReclamationRepository repo;
	
	
	    //URL http://localhost:8089/SpringMVC/reclamation/retrieve-all-reclamations
		@GetMapping("/retrieve-all-reclamations")
		public List<Reclamation> retrieveAllReclamations(){
			List<Reclamation> reclamation = reclamationService.retrieveAllReclamations();
			return reclamation;
			
		}
		
		// http://localhost:8089/SpringMVC/reclamation/add-reclamation
		@PostMapping("/add-reclamation")
		public Reclamation add_Reclamation(@RequestBody Reclamation r) {
			reclamationService.sending();
			return reclamationService.addReclamation(r);
		}
		
		// http://localhost:8089/SpringMVC/reclamation/remove-reclamation/{reclamation-id}
		@DeleteMapping("/remove-reclamation/{reclamation_id}")
		@ResponseBody
		public void remove_Reclamation(@PathVariable Long reclamation_id) {
			reclamationService.sendingdelete();
			reclamationService.deleteReclamation(reclamation_id);
		}
		
		// http://localhost:8089/SpringMVC/reclamation/update-reclamation
		@PutMapping("/update-reclamation/{id}")
		@ResponseBody
		public Reclamation Update_Reclamation(@RequestBody Reclamation r) {
			return reclamationService.updateReclamation(r);
		}
		
		
		// http://localhost:8089/SpringMVC/reclamation/update-reclamation2
				@PutMapping("/update-reclamation2/{id}")
				@ResponseBody
				public Reclamation Update_Reclamation2(@RequestBody Reclamation r,@PathVariable("id")long id) {
					Reclamation rec= repo.findById(id).get();
					rec.setDateReclamation(r.getDateReclamation());
					rec.setUserEmail(r.getUserEmail());
					rec.setDescription(r.getDescription());
					reclamationService.sendingupdate();
					return reclamationService.updateReclamation(rec);
				}
		
		// http://localhost:8089/SpringMVC/reclamation/retreive-reclamation/{id}
		@GetMapping("/retreive-reclamation/{id}")
		public Reclamation Get_Reclamation(@PathVariable Long id) {
			return reclamationService.retrieveReclamation(id);
		}
		
		// http://localhost:8089/SpringMVC/reclamation/retreiverec/{id}
		@GetMapping("/retreiverec/{id}")
		public List<Reclamation> getListRec(@PathVariable Long id){
			List<Reclamation> r = reclamationService.getRec(id);
			return r;
		}
		
		// http://localhost:8089/SpringMVC/reclamation/countreclamations
		@GetMapping("countreclamations")
		@Scheduled(fixedDelay=1000)
		public  Long countReclams() {
			long x;
			x=reclamationService.countReclamations();
			System.out.println(x);
			return x;
		}

}
