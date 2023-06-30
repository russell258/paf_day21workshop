package sg.edu.nus.iss.paf_day21workshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.paf_day21workshop.model.Customer;
import sg.edu.nus.iss.paf_day21workshop.repo.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository cRepo;

    public List<Customer> getAll(){
        return cRepo.getAllCustomers();
    }

    public Customer getById(Integer id){
        return cRepo.getByIdCustomer(id);
    }

    public List<Customer> getCustomerLimitOffset(Integer limit, Integer offset){
        return cRepo.offsetCustomers(limit, offset);
    }

}
