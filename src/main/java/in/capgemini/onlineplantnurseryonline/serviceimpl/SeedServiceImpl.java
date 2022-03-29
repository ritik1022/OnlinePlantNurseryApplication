package in.capgemini.onlineplantnurseryonline.serviceimpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.capgemini.onlineplantnurseryonline.exception.SeedIdNotFoundException;
import in.capgemini.onlineplantnurseryonline.models.Seed;
import in.capgemini.onlineplantnurseryonline.repository.SeedRepository;
import in.capgemini.onlineplantnurseryonline.service.SeedService;
@Service
public class SeedServiceImpl implements SeedService {
	@Autowired
	private SeedRepository seedRepository;

	@Override
	public Seed addSeed(Seed seed) {
		seed.setSeedId(seed.getSeedId());
		seed.setCommonName(seed.getCommonName().toUpperCase());
		return seedRepository.save(seed);
	}

	@Override
	public Seed updateSeed(Seed seed) throws SeedIdNotFoundException{
		Seed seedOptional = seedRepository.findById(seed.getSeedId());
		
		if(seedOptional==null) {
			throw new SeedIdNotFoundException("Invalid seed id...Cannot update");	
		}
		seedOptional.setCommonName(seedOptional.getCommonName().toUpperCase());
		return seedRepository.save(seedOptional);
			
	}

	@Override

		public Seed deleteSeed(Seed seed) throws SeedIdNotFoundException {
			Seed seedOptional = seedRepository.findById(seed.getSeedId());		
			if(seedOptional==null) {
				throw new SeedIdNotFoundException("Invalid seed id...Cannot delete");	
			}
			seedRepository.delete(seed);
			return seedOptional;
		}

	@Override
	public Seed viewSeed(int seedId) throws SeedIdNotFoundException {
		Seed seedOptional = seedRepository.findById(seedId);
		if(seedOptional==null)
		{
			throw new SeedIdNotFoundException("Seed with ID"+seedId+"not found");
		}
		return seedOptional;
	}

	@Override
	public List<Seed> getSeeds() {
		return seedRepository.findAll();
	}

	@Override
	public List<Seed> getSeeds(String type) {
		return seedRepository.findByTypesOfSeeds(type);
	}
	@Override
	public Seed viewSeed(String commonName) throws SeedIdNotFoundException {
		Seed seedOptional = seedRepository.findByCommonName(commonName.toUpperCase());
		if(seedOptional==null)
		{
			throw new SeedIdNotFoundException("Seed with Name"+commonName.toUpperCase()+"not found");
		}
		return seedOptional;
	}
		
	}
	
	

