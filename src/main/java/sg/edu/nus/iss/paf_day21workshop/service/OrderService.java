package sg.edu.nus.iss.paf_day21workshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.paf_day21workshop.model.Order;
import sg.edu.nus.iss.paf_day21workshop.repo.OrderRepository;

@Service
public class OrderService {
    @Autowired
    OrderRepository oRepo;

    public List<Order> getOrdersFromId(Integer id){
        return oRepo.getAllOrders(id);
    }

}
