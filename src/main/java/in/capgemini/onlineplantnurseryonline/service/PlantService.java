package in.capgemini.onlineplantnurseryonline.service;

import java.util.List;

import in.capgemini.onlineplantnurseryonline.exception.PlantIdNotFoundException;
import in.capgemini.onlineplantnurseryonline.models.Plant;

public interface PlantService {
	public Plant addPlant(Plant plant) ;
	public Plant updatePlant(Plant plant) throws PlantIdNotFoundException;
	public Plant deletePlant(Plant plant) throws PlantIdNotFoundException;
	Plant viewPlant(int id) throws PlantIdNotFoundException;
	Plant viewPlant(String commonName) throws PlantIdNotFoundException;
	List<Plant> getPlants();
	List<Plant> getPlants(String type);
}