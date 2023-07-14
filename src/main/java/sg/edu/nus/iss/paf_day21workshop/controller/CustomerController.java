package sg.edu.nus.iss.paf_day21workshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.paf_day21workshop.model.Customer;
import sg.edu.nus.iss.paf_day21workshop.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    
    @Autowired
    CustomerService cSvc;

    @GetMapping
    public List<Customer> getAllCustomers(){
        return cSvc.getAll();
    }

    @GetMapping("/limit")
    public List<Customer> getCustomersLimitOffset(@RequestParam("limit") int limit, @RequestParam("offset") int offset){
        return cSvc.getCustomerLimitOffset(limit, offset);
    }

        // need to add in 404 error for find by id

    @GetMapping("/{cust-id}")
    public Customer getCustomerById(@PathVariable("cust-id") int custId){
        return cSvc.getById(custId);
    }

}
