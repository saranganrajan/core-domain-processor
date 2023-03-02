package com.saranganrajan.apps.coredomainprocessor.service.payment;

import com.saranganrajan.apps.coredomainprocessor.external.database.entity.PaymentHistoryEntity;
import com.saranganrajan.apps.coredomainprocessor.external.database.entity.PaymentModeEntity;
import com.saranganrajan.apps.coredomainprocessor.external.database.repository.PaymentHistoryRepository;
import com.saranganrajan.apps.coredomainprocessor.external.database.repository.PaymentModeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentHistoryRepository paymentHistoryRepository;
    @Autowired
    PaymentModeRepository paymentModeRepository;

    public PaymentServiceImpl(PaymentHistoryRepository paymentHistoryRepository, PaymentModeRepository paymentModeRepository) {
        this.paymentHistoryRepository = paymentHistoryRepository;
        this.paymentModeRepository = paymentModeRepository;
    }

    @Override
    public Optional<PaymentHistoryEntity> getPaymentHistories(String policyNumber) {
        return paymentHistoryRepository.findById(policyNumber);
    }

    @Override
    public List<PaymentModeEntity> getPaymentModes() {
        return paymentModeRepository.findAll();
    }

    @Override
    public PaymentHistoryEntity savePayment(PaymentHistoryEntity paymentHistoryEntity) {
        return paymentHistoryRepository.save(paymentHistoryEntity);
    }
}
