package com.saranganrajan.apps.coredomainprocessor.service.product;

import com.saranganrajan.apps.coredomainprocessor.external.database.entity.PlanEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlanService {
    List<PlanEntity> getActivePlans();
}
