package in.capgemini.onlineplantnurseryapplication.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.capgemini.onlineplantnurseryapplication.exceptions.CustomerException;
import in.capgemini.onlineplantnurseryapplication.models.Customer;
import in.capgemini.onlineplantnurseryapplication.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
private CustomerRepository customerRepo;
	
public Customer saveCustomer(Customer customer) {
	return customerRepo.save(customer);
		
}
public Customer getCustomerById(int id) throws CustomerException{
	if(!customerRepo.existsById(id)) {
		throw new CustomerException("Customer Not Found");
	}
	return customerRepo.findById(id).get();
}
public Customer updateCustomer(int id, Customer customer) throws CustomerException {
    customer.setId(id);
    Optional<Customer> customerTemp=customerRepo.findById(customer.getId());
    if(customerTemp.isPresent()) {
    	 Customer existingCustomer = customerTemp.get();
    	    BeanUtils.copyProperties(customer,existingCustomer,"cust_id");
    	    return customerRepo.saveAndFlush(existingCustomer);
    }
throw new CustomerException("Id Not Found");
}
public String deletecustomer(int id) throws CustomerException{
	Optional<Customer> customerTemp=customerRepo.findById(id);
	if(customerTemp.isPresent()){
		 customerRepo.deleteById(id);
		 return "Customer Deleted";
	}
	throw new CustomerException("Customer Not Found");

}


}
