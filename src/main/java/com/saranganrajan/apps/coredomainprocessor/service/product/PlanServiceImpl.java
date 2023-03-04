package com.saranganrajan.apps.coredomainprocessor.service.product;

import com.saranganrajan.apps.coredomainprocessor.external.database.entity.PlanEntity;
import com.saranganrajan.apps.coredomainprocessor.external.database.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PlanServiceImpl implements PlanService {

    @Autowired
    PlanRepository planRepository;

    public PlanServiceImpl(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    @Override
    public List<PlanEntity> getActivePlans() {
        return planRepository.findAll().stream()
                .filter(PlanEntity::isActive)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PlanEntity> getPlanById(String planCode) {
        return planRepository.findById(planCode);
    }
}
