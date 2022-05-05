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

import consommi.tounsi.entity.Livreur;
import consommi.tounsi.repository.LivreurRepository;
import consommi.tounsi.service.LivreurService;


@RequestMapping("/livreur")
@RestController
@CrossOrigin
public class LivreurRestControl {
	
	//Weak Linking 
	@Autowired
	LivreurService livreurService;
	
	@Autowired
	LivreurRepository livrepo;
	
	//URL http://localhost:8089/SpringMVC/livreur/retrieve-all-livreurs
	@GetMapping("/retrieve-all-livreurs")
	public List<Livreur> retrieveAllLivreurs(){
		List<Livreur> livreur = livreurService.retrieveAllLivreurs();
		return livreur;
		
	}
	
	// http://localhost:8089/SpringMVC/livreur/add-livreur
	@PostMapping("/add-livreur")
	public Livreur add_Livreur(@RequestBody Livreur l) {
		livreurService.sending();
		return livreurService.addLivreur(l);
	}
	
	
	// http://localhost:8089/SpringMVC/livreur/remove-livreur/{livreur-id}
	@DeleteMapping("/remove-livreur/{livreur_id}")
	@ResponseBody
	public void remove_Livreur(@PathVariable Long livreur_id) {
		livreurService.sendingsup();
		livreurService.deleteLivreur(livreur_id);
	}
	
	// http://localhost:8089/SpringMVC/livreur/update-livreur2
	@PutMapping("/update-livreur2/{id}")
	@ResponseBody
	public Livreur Update_Livreur2(@RequestBody Livreur r,@PathVariable("id")long id) {
		Livreur liv= livrepo.findById(id).get();
		liv.setFirstName(r.getFirstName());
		liv.setLastName(r.getLastName());
		liv.setEmail(r.getEmail());
		liv.setCin(r.getCin());
		liv.setDateNaissance(r.getDateNaissance());
		liv.setScore(r.getScore());
		liv.setCharge_travail(r.getCharge_travail());
		liv.setSalaire(r.getSalaire());
		livreurService.sendingupdate();
		return livreurService.updateLivreur(liv);
	}
	// http://localhost:8089/SpringMVC/livreur/update-livreur
	@PutMapping("/update-livreur")
	@ResponseBody
	public Livreur Update_Livreur(@RequestBody Livreur l) {
		return livreurService.updateLivreur(l);
	}
	
	// http://localhost:8089/SpringMVC/livreur/retreive-livreur/{id}
	@GetMapping("/retreive-livreur/{id}")
	public Livreur Get_Livreur(@PathVariable Long id) {
		return livreurService.retrieveLivreur(id);
		
	}
	
	// http://localhost:8089/SpringMVC/livreur/retrieve-calcule-primes-livreur/{id}
	@GetMapping("/retrieve-calcule-primes-livreur/{id}")
	public Livreur Prime_Livreur(@PathVariable Long id) {
		return livreurService.retrieveEtCalculePrimeLivreur(id);
	}
	
	// http://localhost:8089/SpringMVC/livreur/retreiveliv/{id}
	@GetMapping("/retreiveliv/{id}")
	public List<Livreur> getListLiv(@PathVariable Long id){
		List<Livreur> l = livreurService.getLiv(id);
		return l;
	}
	
	// http://localhost:8089/SpringMVC/livreur/countlivreurs
	@GetMapping("/countlivreurs")
	@Scheduled(fixedDelay=1000)
	public  Long countLivreurs() {
		long y;
		y=livreurService.countEntities();
		System.out.println(y);
		return y;
	}
	
	

}
