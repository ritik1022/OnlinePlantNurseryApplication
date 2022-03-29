package in.capgemini.onlineplantnurseryonline.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.capgemini.onlineplantnurseryonline.models.Plant;
@Repository
public interface PlantRepository extends CrudRepository<Plant, Integer> {
	Plant findById(int id);
	Plant findByCommonName(String commonName);
List<Plant> findAll();
	List<Plant> findByTypesOfPlant(String typeOfPlants);
}