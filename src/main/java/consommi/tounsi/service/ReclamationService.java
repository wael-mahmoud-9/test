package consommi.tounsi.service;

import java.util.List;

import consommi.tounsi.entity.Reclamation;

public interface ReclamationService {
	
	List<Reclamation> retrieveAllReclamations();
	Reclamation addReclamation(Reclamation r);
	void deleteReclamation(Long id);
	Reclamation updateReclamation(Reclamation r);
	Reclamation retrieveReclamation(Long id);
	List<Reclamation> getRec(Long id);
	Long countReclamations();
	void sending();
	void sendingupdate();
	void sendingdelete();

}
