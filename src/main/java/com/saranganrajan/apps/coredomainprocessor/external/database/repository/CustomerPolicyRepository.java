package com.saranganrajan.apps.coredomainprocessor.external.database.repository;

import com.saranganrajan.apps.coredomainprocessor.external.database.entity.CustomerPolicyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerPolicyRepository extends JpaRepository<CustomerPolicyEntity, String> {
}
