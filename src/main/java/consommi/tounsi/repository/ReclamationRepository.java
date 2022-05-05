package consommi.tounsi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import consommi.tounsi.entity.Reclamation;

@Repository
public interface ReclamationRepository extends CrudRepository<Reclamation, Long> {

}
