package consommi.tounsi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import consommi.tounsi.entity.Livreur;

@Repository
public interface LivreurRepository extends CrudRepository<Livreur, Long> {
	
}
