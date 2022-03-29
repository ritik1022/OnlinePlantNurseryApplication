package in.capgemini.onlineplantnurseryonline.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import in.capgemini.onlineplantnurseryonline.models.Plant;
import in.capgemini.onlineplantnurseryonline.service.PlantService;
import in.capgemini.onlineplantnurseryonline.serviceimpl.ErrorMapValidationService;

@RestController
@RequestMapping("/products")
public class PlantController {
	@Autowired
	private PlantService plantService;
	@Autowired
	private ErrorMapValidationService errorMapValidationService; 
	@PostMapping("/admin/plant")
	public ResponseEntity<?> addPlant(@Valid @RequestBody Plant plant,BindingResult result) {
		ResponseEntity<?> errorMap=errorMapValidationService.mapValidationError(result);
		if(errorMap!=null) return errorMap;
		Plant savedPlant = plantService.addPlant(plant);
		return new ResponseEntity<Plant>(savedPlant,HttpStatus.CREATED);
	}
	@PutMapping("/admin/plants")
	public ResponseEntity<Plant> updatePlant(@RequestBody Plant plant) {
		plantService.updatePlant(plant);
		return new ResponseEntity<Plant>(plant,HttpStatus.CREATED);
	}
	@DeleteMapping("/admin/plants")
	public ResponseEntity<Plant> deletePlant(@RequestBody Plant plant){
		return new ResponseEntity<Plant> (plantService.deletePlant(plant),HttpStatus.ACCEPTED);
	}
	@GetMapping("/admin/plants/id/{id}")
	public ResponseEntity<Plant> getPlant(@PathVariable int id){
		return new ResponseEntity<Plant>(plantService.viewPlant(id),HttpStatus.OK);	
	}
	@GetMapping("/admin/plants/commonname/{commonName}")
	public ResponseEntity<Plant> getPlant(@PathVariable String commonName) {
		return new ResponseEntity<Plant>(plantService.viewPlant(commonName),HttpStatus.ACCEPTED);	
	}
	@GetMapping("/admin/plants")
	public ResponseEntity<List<Plant>> getPlants(){
		List<Plant> plantList = plantService.getPlants();
		return new ResponseEntity<List<Plant>>(plantList,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/admin/plants/typeOfplant/{typeOfPlant}")
	public ResponseEntity<List<Plant>> getPlants(@PathVariable String typeOfPlant){
		List<Plant> plantList = plantService.getPlants(typeOfPlant);
		return new ResponseEntity<List<Plant>>(plantList,HttpStatus.ACCEPTED);
	}
	
}