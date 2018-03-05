package miw.daos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import miw.entities.Car;

@RepositoryRestResource(collectionResourceRel = "cars", path = "cars")
public interface CarDao extends JpaRepository<Car, Integer> {

	List<Car> findByModel(String model);

	@Transactional
	int deleteByModel(String model);

}
