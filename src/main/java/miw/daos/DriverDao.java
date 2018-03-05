package miw.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import miw.entities.Driver;

@RepositoryRestResource(collectionResourceRel = "drivers", path = "drivers")
public interface DriverDao extends JpaRepository<Driver, Integer> {

	@Query("select d from Driver d where d.car.model = ?1")
	List<Driver> findByCarModel(String model);

}
