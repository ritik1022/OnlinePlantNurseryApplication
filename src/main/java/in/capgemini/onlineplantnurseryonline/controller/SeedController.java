package in.capgemini.onlineplantnurseryonline.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.capgemini.onlineplantnurseryonline.models.Seed;
import in.capgemini.onlineplantnurseryonline.service.SeedService;
import in.capgemini.onlineplantnurseryonline.serviceimpl.ErrorMapValidationService;

@RestController
@RequestMapping("/products")
public class SeedController {
	@Autowired
	private SeedService seedService;
	@Autowired
	private ErrorMapValidationService errorMapValidationService; 
	@PostMapping("/admin/seed")
	public ResponseEntity<?> addSeed(@Valid @RequestBody Seed seed,BindingResult result) {
		ResponseEntity<?> errorMap=errorMapValidationService.mapValidationError(result);
		if(errorMap!=null) return errorMap;
		Seed savedSeed = seedService.addSeed(seed);
		return new ResponseEntity<Seed>(savedSeed,HttpStatus.CREATED);
	}
	@PutMapping("/admin/seeds")
	public ResponseEntity<Seed> updateSeed(@RequestBody Seed seed) {
		seedService.updateSeed(seed);
		return new ResponseEntity<Seed>(seed,HttpStatus.CREATED);
	}
	@DeleteMapping("/admin/seeds")
	public ResponseEntity<Seed> deleteSeed(@RequestBody Seed seed){
		return new ResponseEntity<Seed> (seedService.deleteSeed(seed),HttpStatus.ACCEPTED);
	}
	@GetMapping("/admin/seeds/id/{id}")
	public ResponseEntity<Seed> getSeed(@PathVariable int id){
		return new ResponseEntity<Seed>(seedService.viewSeed(id),HttpStatus.OK);	
	}
	@GetMapping("/admin/seeds/commonname/{commonName}")
	public ResponseEntity<Seed> getSeed(@PathVariable String commonName) {
		return new ResponseEntity<Seed>(seedService.viewSeed(commonName),HttpStatus.ACCEPTED);	
	}
	@GetMapping("/admin/seeds")
	public ResponseEntity<List<Seed>> getSeeds(){
		List<Seed> seedList = seedService.getSeeds();
		return new ResponseEntity<List<Seed>>(seedList,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/admin/seeds/typeOfSeed/{typeOfSeed}")
	public ResponseEntity<List<Seed>> getSeeds(@PathVariable String typeOfSeed){
		List<Seed> seedList = seedService.getSeeds(typeOfSeed);
		return new ResponseEntity<List<Seed>>(seedList,HttpStatus.ACCEPTED);
	}
	
}
