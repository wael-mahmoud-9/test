package consommi.tounsi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import consommi.tounsi.entity.Reclamation;
import consommi.tounsi.repository.ReclamationRepository;

@Service
public class ReclamationServiceImpl implements ReclamationService {
	
	@Autowired 
	ReclamationRepository reclamationRepository;
	
	@Autowired
	EmailSending emailsend;
	
	
	@Override
	public List<Reclamation> retrieveAllReclamations() {
		return (List<Reclamation>) reclamationRepository.findAll();
	}
	
	@Override
	public Reclamation addReclamation(Reclamation r) {
		return reclamationRepository.save(r);
	}

	@Override
	public void deleteReclamation(Long id) {
		reclamationRepository.deleteById(id);
	}

	@Override
	public Reclamation updateReclamation(Reclamation r) {
		return reclamationRepository.save(r);
	}

	@Override
	public Reclamation retrieveReclamation(Long id) {
		Reclamation r = reclamationRepository.findById(id).get();
		return r;
	}
	
	@Override
	 public List <Reclamation> getRec(Long id){
		List <Reclamation> rs = new ArrayList<>();
		rs.add(reclamationRepository.findById(id).get());
		return rs; 
	}
	
	@Override
	public Long countReclamations() {
		return reclamationRepository.count();
	}
	
	@Override
	public void sending() {
		emailsend.sendEmail("wael.mahmoud@esprit.tn", "Votre reclamation est ajoutée avec succès", "Reclamation ajouté");
	}
	@Override
	public void sendingdelete() {
		emailsend.sendEmail("wael.mahmoud@esprit.tn", "Votre reclamation est supprimée avec succès", "Reclamation supprimée");
	}
	@Override
	public void sendingupdate() {
		emailsend.sendEmail("wael.mahmoud@esprit.tn", "Votre reclamation est modifiée avec succès", "Reclamation modifiée");
	}
	

}
