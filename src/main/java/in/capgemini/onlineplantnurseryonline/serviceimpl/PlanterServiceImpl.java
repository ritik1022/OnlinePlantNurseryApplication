package in.capgemini.onlineplantnurseryonline.serviceimpl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.capgemini.onlineplantnurseryapplication.repository.PlanterRepository;
import in.capgemini.onlineplantnurseryonline.domain.Planter;
import in.capgemini.onlineplantnurseryonline.exception.PlanterIdException;
import in.capgemini.onlineplantnurseryonline.service.PlanterService;

@Service
public class PlanterServiceImpl implements PlanterService {

	@Autowired
	private PlanterRepository planterRepository;
	
	
	public Planter addPlanter(Planter planter) {
	      return planterRepository.save(planter);
	  }

	  @Override
	  public Iterable<Planter> listOfPlanters() {
	    planterRepository.findAll();
	    return planterRepository.findAll();
	  }



	  @Override
	  public void delete(Long planterId) {
	    try {
	    	planterRepository.deleteById(planterId);
	    }
	    catch (Exception e) {
	      // TODO: handle exception
	      throw new PlanterIdException("Planter Id "+planterId+" Doesn't Exist");
	    }
	  }

	  @Override
	  public Planter findPlanterByplanterId(Long planterId) {
	    return planterRepository.findByPlanterId(planterId);
	  }

	  @Override
	  public Iterable<Planter> findallPlanters() {
	    return planterRepository.findAll();
	  }

	@Override
	public void updatePlanter(long id, Planter planter) {
		planterRepository.save(planter);
		
	}

}
