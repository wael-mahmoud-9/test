package consommi.tounsi.service;

import java.util.List;

import consommi.tounsi.entity.Livreur;

public interface LivreurService {
	
	List<Livreur> retrieveAllLivreurs();
	Livreur addLivreur(Livreur l);
	void deleteLivreur(Long id);
	Livreur updateLivreur(Livreur l);
	Livreur retrieveLivreur(Long id);
	Livreur retrieveEtCalculePrimeLivreur(Long id);
	List<Livreur> getLiv(Long id);
	Long countEntities();
	void sending();
	void sendingsup();
	void sendingupdate();
	

}
