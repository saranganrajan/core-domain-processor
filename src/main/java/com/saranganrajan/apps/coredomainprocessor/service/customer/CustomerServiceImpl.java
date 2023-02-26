package com.saranganrajan.apps.coredomainprocessor.service.customer;

import com.saranganrajan.apps.coredomainprocessor.external.database.entity.CustomerEntity;
import com.saranganrajan.apps.coredomainprocessor.external.database.entity.PolicyEntity;
import com.saranganrajan.apps.coredomainprocessor.external.database.repository.CustomerRepository;
import com.saranganrajan.apps.coredomainprocessor.external.database.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerEntity> getCustomers() throws SQLException {
            return customerRepository.findAll();
    }
}
