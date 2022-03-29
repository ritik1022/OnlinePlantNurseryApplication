package in.capgemini.onlineplantnurseryapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.capgemini.onlineplantnurseryapplication.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{
	
}
