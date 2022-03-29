package in.capgemini.onlineplantnurseryonline.web;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import in.capgemini.onlineplantnurseryonline.domain.Planter;
import in.capgemini.onlineplantnurseryonline.service.PlanterService;
import in.capgemini.onlineplantnurseryonline.serviceimpl.MapValidationErrorService;


@RestController
@RequestMapping("/api/onlineplantnursery/planter")
public class PlanterController {
	
	@Autowired
	private PlanterService planterService;
	
	
	  @Autowired
	  MapValidationErrorService mapValidationErrorService;
	  
	  
	  @PostMapping("")
	  public ResponseEntity<?> addNewPlanter(@Valid @RequestBody Planter planter,BindingResult result) {
	    
	    ResponseEntity<?> errorMesssage=mapValidationErrorService.mapValidationError(result);
	    if(errorMesssage!=null) {
	      return errorMesssage;
	    }
	    Planter savedPlanter=planterService.addPlanter(planter);
	    return new ResponseEntity<Planter>(savedPlanter,HttpStatus.ACCEPTED);
	  }
	  
	  @GetMapping("/{planterId}")
	  public ResponseEntity<?> getPlanterById(@PathVariable("planterId") Long planterId){
	    Planter planter=planterService.findPlanterByplanterId(planterId);
	    return new ResponseEntity<Planter>(planter, HttpStatus.ACCEPTED);
	    
	  }
	  @GetMapping("/listall")
	  public ResponseEntity<?> getAllPlanters(){
	    return new ResponseEntity<Iterable<Planter>>(planterService.findallPlanters(),HttpStatus.OK);
	  }
	  
	  @PutMapping("/planters/{id}")
	  public void updatePlanter(long id, Planter planter) {
		  planterService.updatePlanter(id, planter);
		  
	  }
	  
	  @DeleteMapping("/{planterId}")
	  public ResponseEntity<?> deleteById(@Valid @PathVariable("planterId") Long planterId){
	    planterService.delete(planterId);
	    return new ResponseEntity<String>(" Planter "+planterId+"Deleted sucessfully",HttpStatus.OK);
	  }

}
