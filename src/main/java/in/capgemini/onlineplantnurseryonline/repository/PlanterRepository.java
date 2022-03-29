package in.capgemini.onlineplantnurseryonline.repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import in.capgemini.onlineplantnurseryonline.domain.Planter;

@Repository
public interface PlanterRepository extends CrudRepository<Planter,Long>{

	Planter findByPlanterId(Long planterId);


}
