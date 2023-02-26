package com.saranganrajan.apps.coredomainprocessor.service.customer;

import com.saranganrajan.apps.coredomainprocessor.external.database.entity.CustomerEntity;
import com.saranganrajan.apps.coredomainprocessor.external.database.entity.PolicyEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public interface CustomerService {
    public List<CustomerEntity> getCustomers() throws SQLException;
}
