package sg.moe.nus.iss.day21_workshop.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;
import sg.moe.nus.iss.day21_workshop.model.Customer;
import sg.moe.nus.iss.day21_workshop.model.Order;
import sg.moe.nus.iss.day21_workshop.service.CustomerService;

@RestController
@RequestMapping("/api")

public class CustomerController {
    @Autowired
    CustomerService customerSvc; 

    Logger logger = Logger.getLogger(CustomerController.class.getName());

    //Task 1. Get a list of all customers
    @GetMapping("/customers")
    public List<Customer> getAllCustomersLimitOffset(@RequestParam("limit")
    int limit, @RequestParam("offset") int offset){
        return customerSvc.retrieveAllCustomersLimitOffset(limit, offset); 
        
    }

    //Task 2: Get customer by Id
    //@GetMapping("/customers/{id}")
    //>>>>change to PathVariable
    // public Customer getCustomerById(@RequestParam("id") int id, HttpServletResponse res){
    //     try {
    //         return customerSvc.retrieveCustomerById(id); 
    //     } catch (Exception e) {
    //         logger.warning("Unable to retrieve id no. %d".formatted(id));
    //         res.setStatus(404);
    //         return null; 
    //     }
    
    // }
    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable(required=false, name="id") int id, HttpServletResponse res){
        try {
            return customerSvc.retrieveCustomerById(id); 
        } catch (Exception e) {
            logger.warning("Unable to retrieve id no. %d".formatted(id));
            res.setStatus(404);
            return null; 
        }
    
    }


    //Task 3
    // GET /api/customer/<customer_id>/orders
    // Accept: application/json
    @GetMapping(path="/customers/{customerId}/orders", produces="application/json")
    @ResponseBody
    public List<Order> getAllOrdersByCustomerId(@PathVariable(required=false, name="customerId") int customerId, HttpServletResponse res){
        try {
            List<Order> orders = customerSvc.retrieveOrdersByCustomerId(customerId); 

            if (orders.isEmpty()){
                res.setStatus(404);
                logger.warning("There are no orders for the customer id no. %d".formatted(customerId));
                return null; 
            }
            logger.info("Retrieved orders for customer id no. %d".formatted(customerId));
            return orders; 

        } catch (Exception e) {
            logger.warning("Unable to retrieve id no. %d".formatted(customerId));
            res.setStatus(404);
            return null; 
        }
       
        
    }


}


