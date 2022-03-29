package in.capgemini.onlineplantnurseryonline.serviceimpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.capgemini.onlineplantnurseryonline.exception.PlantIdNotFoundException;
import in.capgemini.onlineplantnurseryonline.models.Plant;
import in.capgemini.onlineplantnurseryonline.repository.PlantRepository;
import in.capgemini.onlineplantnurseryonline.service.PlantService;
@Service
public class PlantServiceImpl implements PlantService {
	@Autowired
	private PlantRepository plantRepository;

	@Override
	public Plant addPlant(Plant plant) {
		plant.setPlantId(plant.getPlantId());
		plant.setCommonName(plant.getCommonName().toUpperCase());
		return plantRepository.save(plant);
	}

	@Override
	public Plant updatePlant(Plant plant) throws PlantIdNotFoundException{
		Plant plantOptional = plantRepository.findById(plant.getPlantId());
		
		if(plantOptional==null) {
			throw new PlantIdNotFoundException("Invalid plant id...Cannot update");	
		}
		plantOptional.setCommonName(plantOptional.getCommonName().toUpperCase());
		return plantRepository.save(plantOptional);
			
	}

	@Override

		public Plant deletePlant(Plant plant) throws PlantIdNotFoundException {
			Plant plantOptional = plantRepository.findById(plant.getPlantId());		
			if(plantOptional==null) {
				throw new PlantIdNotFoundException("Invalid plant id...Cannot delete");	
			}
			plantRepository.delete(plant);
			return plantOptional;
		}

	@Override
	public Plant viewPlant(int plantId) throws PlantIdNotFoundException {
		Plant plantOptional = plantRepository.findById(plantId);
		if(plantOptional==null)
		{
			throw new PlantIdNotFoundException("Plant with ID"+plantId+"not found");
		}
		return plantOptional;
	}

	@Override
	public List<Plant> getPlants() {
		return plantRepository.findAll();
	}

	@Override
	public List<Plant> getPlants(String type) {
		return plantRepository.findByTypesOfPlant(type);
	}
	@Override
	public Plant viewPlant(String commonName) throws PlantIdNotFoundException {
		Plant plantOptional = plantRepository.findByCommonName(commonName.toUpperCase());
		if(plantOptional==null)
		{
			throw new PlantIdNotFoundException("Plant with Name"+commonName.toUpperCase()+"not found");
		}
		return plantOptional;
	}
		
	}