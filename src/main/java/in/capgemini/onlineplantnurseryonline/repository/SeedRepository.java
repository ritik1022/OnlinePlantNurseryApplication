package in.capgemini.onlineplantnurseryonline.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.capgemini.onlineplantnurseryonline.models.Seed;
@Repository
public interface SeedRepository extends CrudRepository<Seed, Integer> {
	Seed findById(int id);
	Seed findByCommonName(String commonName);
List<Seed> findAll();
	List<Seed> findByTypesOfSeeds(String typeOfSeeds);
}
