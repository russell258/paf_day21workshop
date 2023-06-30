package sg.edu.nus.iss.paf_day21workshop.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {
    @Autowired
    JdbcTemplate jdbc;

    private final String findAllOrdersSQL = "select * from orders where customer_id = ?";
}
