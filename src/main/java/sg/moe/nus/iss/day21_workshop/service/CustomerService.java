package sg.moe.nus.iss.day21_workshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.moe.nus.iss.day21_workshop.model.Customer;
import sg.moe.nus.iss.day21_workshop.model.Order;
import sg.moe.nus.iss.day21_workshop.repository.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepo; 

    //Task 1: Get ALL customers
    public List<Customer> retrieveAllCustomersLimitOffset (int limit, int offset){
        return customerRepo.getAllCustomers(limit, offset);
    }
    //Task 2: Get customer by Id
    public Customer retrieveCustomerById (int id){
        return customerRepo.getCustomerById(id);
    }
    //Task 3: Retrieve all orders by customer Id
    public List<Order> retrieveOrdersByCustomerId(int customerId){
        return customerRepo.getOrdersByCustId(customerId);
    }
}
