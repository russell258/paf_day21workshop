package sg.edu.nus.iss.paf_day21workshop.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.paf_day21workshop.model.Order;

@Repository
public class OrderRepository {
    @Autowired
    JdbcTemplate jdbc;

    //get all orders for specified customer id
    private final String findAllOrdersSQL = "select * from orders where customer_id = ?";

    public List<Order> getAllOrders(Integer customerId){
        List<Order> customerOrders = new ArrayList<Order>();
        customerOrders = jdbc.query(findAllOrdersSQL, BeanPropertyRowMapper.newInstance(Order.class),customerId);

        if (customerOrders.isEmpty()){
            throw new IllegalArgumentException("No orders found");
        }
        return customerOrders;
    } 

}
