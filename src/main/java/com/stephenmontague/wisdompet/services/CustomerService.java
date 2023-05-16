package com.stephenmontague.wisdompet.services;

import com.stephenmontague.wisdompet.data.entities.CustomerEntity;
import com.stephenmontague.wisdompet.data.repositories.CustomerRepository;
import com.stephenmontague.wisdompet.web.errors.NotFoundException;
import com.stephenmontague.wisdompet.web.models.Customer;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers(String filterEmail) {
        List<Customer> customers = new ArrayList<>();
        if (StringUtils.hasLength(filterEmail)) {
            CustomerEntity entity = this.customerRepository.findByEmailAddress(filterEmail);
            customers.add(this.translateDbToWeb(entity));
        } else {
            Iterable<CustomerEntity> entities = this.customerRepository.findAll();
            entities.forEach(entity -> {
                customers.add(this.translateDbToWeb(entity));
            });
        }
        return customers;
    }

    public Customer getCustomer(long id) {
        Optional<CustomerEntity> optional = this.customerRepository.findById(id);
        if (optional.isEmpty()) {
            throw new NotFoundException("Customer not found with id");
        }
        return this.translateDbToWeb(optional.get());
    }

    public Customer createOrUpdate(Customer customer) {
        CustomerEntity entity = this.translateWebToDb(customer);
        entity = this.customerRepository.save(entity);
        return this.translateDbToWeb(entity);
    }

    public void deleteCustomer(long id) {
        this.customerRepository.deleteById(id);
    }

    private CustomerEntity translateWebToDb(Customer customer) {
        CustomerEntity entity = new CustomerEntity();
        entity.setId(customer.getCustomerId());
        entity.setAddress(customer.getAddress());
        entity.setEmailAddress(customer.getEmailAddress());
        entity.setFirstName(customer.getFirstName());
        entity.setLastName(customer.getLastName());
        entity.setPhoneNumber(customer.getPhoneNumber());

        return entity;
    }

    private Customer translateDbToWeb(CustomerEntity customerEntity) {
        return new Customer(customerEntity.getId(), customerEntity.getFirstName(), customerEntity.getLastName(),
                customerEntity.getEmailAddress(), customerEntity.getPhoneNumber(), customerEntity.getAddress());
    }
}
