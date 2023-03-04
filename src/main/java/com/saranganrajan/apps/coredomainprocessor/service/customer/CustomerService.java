package com.saranganrajan.apps.coredomainprocessor.service.customer;

import com.saranganrajan.apps.coredomainprocessor.external.database.entity.CustomerEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public interface CustomerService {
    public List<CustomerEntity> getCustomers() throws SQLException;
    Optional<CustomerEntity> getCustomerById(String customerNumber);
}
