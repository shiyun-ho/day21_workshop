package sg.moe.nus.iss.day21_workshop.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import sg.moe.nus.iss.day21_workshop.model.Customer;
import sg.moe.nus.iss.day21_workshop.model.Order;

@Repository
public class CustomerRepository {
    @Autowired
    JdbcTemplate jdbcTemplate; 

    //find all customers
    private final String findAllSQL = "select * from customers limit ? offset ?"; 

    //function to call all customers
    public List<Customer> getAllCustomers(int limit, int offset){
        final List<Customer> customerList = new ArrayList<Customer>(); 
        final SqlRowSet rs = jdbcTemplate.queryForRowSet(findAllSQL, limit, offset); 

        while (rs.next()){
            Customer cust = new Customer(); 
            cust.setId(rs.getInt("id"));
            cust.setFirstName(rs.getString("first_name"));
            cust.setLastName(rs.getString("last_name"));

            customerList.add(cust); 
        }
        return Collections.unmodifiableList(customerList); 
    }

    //Task 2: Find customer by ID
    private final String findSQLById = "select * from customers where id = ?";
    // select * from customere where id = 1;   
    public Customer getCustomerById(int id){
        return jdbcTemplate.queryForObject(findSQLById, BeanPropertyRowMapper.newInstance(Customer.class)
        , id); 
    }

    //Task 3: Find all orders from the same customer
    private final String findSQLByCustId = "select id, customer_id, order_date, shipped_date, shipper_id, ship_name, ship_address from orders where customer_id = ?";

    public List<Order> getOrdersByCustId(int customerId){
        final List<Order> orderList = new ArrayList<Order>(); 
        final SqlRowSet rs = jdbcTemplate.queryForRowSet(findSQLByCustId, customerId);
        
        while (rs.next()){
            Order order = new Order(); 
            order.setId(rs.getInt("id"));
            order.setCustomerId(rs.getInt("customer_id"));
            // order.setOrderDate(rs.getTime("order_date"));
            // order.setShippedDate(rs.getTime("shipped_date"));
            order.setShipperId(rs.getInt("shipper_id"));
            order.setShipName(rs.getString("ship_name"));
            order.setShipAddress(rs.getString("ship_address"));

            orderList.add(order); 
        }
        return Collections.unmodifiableList(orderList);  

    }

}
