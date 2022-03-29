package in.capgemini.onlineplantnurseryapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.capgemini.onlineplantnurseryapplication.exceptions.CustomerException;
import in.capgemini.onlineplantnurseryapplication.models.Customer;
import in.capgemini.onlineplantnurseryapplication.service.CustomerService;

@RestController
@RequestMapping("/products")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@PostMapping("/create")
    public Customer create(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Integer id)throws CustomerException{
        return customerService.getCustomerById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id)throws CustomerException{
      return  customerService.deletecustomer(id);
    }

    @PutMapping(value = "update/{id}")
    public Customer updateCustomer(@PathVariable int id,@RequestBody Customer customer) throws CustomerException, CustomerException {
        return customerService.updateCustomer(id,customer);
    }
}
