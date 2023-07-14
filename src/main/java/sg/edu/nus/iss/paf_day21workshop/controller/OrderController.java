package sg.edu.nus.iss.paf_day21workshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.server.ResponseStatusException;

import sg.edu.nus.iss.paf_day21workshop.model.Order;
import sg.edu.nus.iss.paf_day21workshop.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    
    @Autowired
    OrderService oSvc;

    @GetMapping("/{cust-id}")
    public ResponseEntity<List<Order>> getOrdersById(@PathVariable("cust-id") int custId){
        List<Order> o = oSvc.getOrdersFromId(custId);

        if (o==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "orders not found");
        }

        return ResponseEntity.ok().body(o);

    }

}
