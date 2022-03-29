package in.capgemini.onlineplantnurseryonline.service;



import in.capgemini.onlineplantnurseryonline.domain.Planter;
public interface PlanterService {

//	public Planter saveOrUpdate(Planter planter);


//	public Planter findPlanterByPlanterId(int planterId);


/*	public List<Planter> getAllPlanters();
	
	public void addPlanter(Planter planter);
	
	public void updatePlanter(String id, Planter planter);
	
	public void deletePlanter(String id);*/
	
	
	
	  Planter addPlanter(Planter planter);
	  public void updatePlanter(long id, Planter planter);
	  Planter findPlanterByplanterId( Long planterId);
	  Iterable<Planter> listOfPlanters();
	  void delete(Long planterId);
	  Iterable<Planter> findallPlanters();
}
