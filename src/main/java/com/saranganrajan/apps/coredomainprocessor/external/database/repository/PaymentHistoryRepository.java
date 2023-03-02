package com.saranganrajan.apps.coredomainprocessor.external.database.repository;

import com.saranganrajan.apps.coredomainprocessor.external.database.entity.PaymentHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentHistoryRepository extends JpaRepository<PaymentHistoryEntity, String> {
}
