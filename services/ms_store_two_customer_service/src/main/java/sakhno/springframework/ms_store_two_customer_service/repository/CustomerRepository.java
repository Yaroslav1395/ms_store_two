package sakhno.springframework.ms_store_two_customer_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import sakhno.springframework.ms_store_two_customer_service.customer.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String > {

}
