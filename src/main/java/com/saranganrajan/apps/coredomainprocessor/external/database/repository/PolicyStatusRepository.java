package com.saranganrajan.apps.coredomainprocessor.external.database.repository;

import com.saranganrajan.apps.coredomainprocessor.external.database.entity.PolicyStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyStatusRepository extends JpaRepository<PolicyStatusEntity, String> {
}
