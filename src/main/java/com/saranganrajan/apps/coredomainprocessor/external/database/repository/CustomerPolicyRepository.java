package com.saranganrajan.apps.coredomainprocessor.external.database.repository;

import com.saranganrajan.apps.coredomainprocessor.external.database.entity.CustomerPolicyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerPolicyRepository extends JpaRepository<CustomerPolicyEntity, String> {

    @Query(value = "select * from ahmf_policy_customer apc where apc.pol_num = ?1", nativeQuery = true)
    List<CustomerPolicyEntity> findCustomerPolicyByPolicyNumber(String policyNumber);
}
