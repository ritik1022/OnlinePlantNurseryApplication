package in.capgemini.onlineplantnurseryonline.service;

import java.util.List;

import in.capgemini.onlineplantnurseryonline.exception.SeedIdNotFoundException;
import in.capgemini.onlineplantnurseryonline.models.Seed;

public interface SeedService {
	public Seed addSeed(Seed seed) ;
	public Seed updateSeed(Seed seed) throws SeedIdNotFoundException;
	public Seed deleteSeed(Seed seed) throws SeedIdNotFoundException;
	Seed viewSeed(int id) throws SeedIdNotFoundException;
	Seed viewSeed(String commonName) throws SeedIdNotFoundException;
	List<Seed> getSeeds();
	List<Seed> getSeeds(String type);
}
