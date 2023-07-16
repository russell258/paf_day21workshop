package sg.edu.nus.iss.paf_day21workshop.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.paf_day21workshop.model.Customer;

@Repository
public class CustomerRepository {
    @Autowired
    JdbcTemplate jdbc;

    private final String findAllSQL = "select * from customers";
    // how to set default for limit to 5 and offset to 0?
    private final String offsetSQL = "select * from customers limit ? offset ?";
    private final String findByIdSQL = "select * from customers where id = ?";

    public List<Customer> getAllCustomers(){
        List<Customer> customerList = new ArrayList<Customer>();
        customerList = jdbc.query(findAllSQL, BeanPropertyRowMapper.newInstance( Customer.class));
        if (customerList.isEmpty()){
            throw new IllegalArgumentException("Customers not found");
        }
        return customerList;
    }

    public List<Customer> offsetCustomers(Integer limit, Integer offset){
        List<Customer> customerList = new ArrayList<Customer>();
        customerList = jdbc.query(offsetSQL, BeanPropertyRowMapper.newInstance(Customer.class), limit, offset);

        if (customerList.isEmpty()){
            throw new IllegalArgumentException("Customers after offset not found");
        }
        return customerList;
    }

    public Customer getByIdCustomer(Integer id){
        Customer c = jdbc.queryForObject(findByIdSQL, BeanPropertyRowMapper.newInstance(Customer.class),id);
        // how to handle exception here, exception auto throws above
        if (c==null){
            throw new IllegalArgumentException("Customer by id: " + id + " not found");
        }
        return c;
    }

}
