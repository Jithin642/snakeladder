package repositories;

import models.Customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerRepository {
    Map<Integer, Customer> customerMap;

    public CustomerRepository(){
        this.customerMap = new HashMap<>();
    }

    public void addCustomer(Customer customer){
        customerMap.put(customer.getCustomerId(), customer);
    }
}
