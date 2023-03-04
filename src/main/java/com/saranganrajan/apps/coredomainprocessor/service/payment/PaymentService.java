package com.saranganrajan.apps.coredomainprocessor.service.payment;

import com.saranganrajan.apps.coredomainprocessor.external.database.entity.PaymentHistoryEntity;
import com.saranganrajan.apps.coredomainprocessor.external.database.entity.PaymentModeEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PaymentService {
    Optional<PaymentHistoryEntity> getPaymentHistories(String policyNumber);
    List<PaymentModeEntity> getPaymentModes();
    PaymentHistoryEntity savePayment(PaymentHistoryEntity paymentHistoryEntity);

    Optional<PaymentModeEntity> getPaymentModeByCode(String mode);
}
