package consommi.tounsi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import consommi.tounsi.entity.Livreur;
import consommi.tounsi.repository.LivreurRepository;

@Service

public class LivreurServiceImpl implements LivreurService {
	
	@Autowired
	LivreurRepository livreurRepository;
	
	@Autowired 
	EmailSending emailsend;

	@Override
	public List<Livreur> retrieveAllLivreurs() {
		return (List<Livreur>) livreurRepository.findAll();
	}

	@Override
	public Livreur addLivreur(Livreur l) {
		return livreurRepository.save(l);
	}

	@Override
	public void deleteLivreur(Long id) {
		livreurRepository.deleteById(id);
	}

	@Override
	public Livreur updateLivreur(Livreur l) {
		return livreurRepository.save(l);
	}

	@Override
	public Livreur retrieveLivreur(Long id) {
		Livreur l = livreurRepository.findById(id).get();
		return l;
	}
	
	@Override
	public Livreur retrieveEtCalculePrimeLivreur (Long id) {
		Livreur l = livreurRepository.findById(id).get();
			
			if (l.getCharge_travail()>20) {
				double salaireetprimes =l.getSalaire();				
				l.setSalaire(salaireetprimes*1.6);
			}
			else {
				double salaireetprimes =l.getSalaire();				
				l.setSalaire(salaireetprimes*1.2);
			}
			
		return l;
	}
	
	@Override
	 public List <Livreur> getLiv(Long id){
		List <Livreur> ls = new ArrayList<>();
		ls.add(livreurRepository.findById(id).get());
		return ls; 
	}
	
	@Override
	public Long countEntities() {
		return livreurRepository.count();
	}
	
	@Override
	public void sending() {
		emailsend.sendEmail("wael.mahmoud@esprit.tn", "Vous avez ajouté un livreur avec succès", "Livreur ajouté");
	}
	@Override
	public void sendingsup() {
		emailsend.sendEmail("wael.mahmoud@esprit.tn", "Vous avez suprrimé un livreur avec succès", "Livreur suprimé");
	}
	@Override
	public void sendingupdate() {
		emailsend.sendEmail("wael.mahmoud@esprit.tn", "Vous avez modifié un livreur avec succès", "Livreur modifié");
	}
	
	
}
