package com.saranganrajan.apps.coredomainprocessor.dto.mapper;

import com.saranganrajan.apps.coredomainprocessor.dto.CustomerPolicy;
import com.saranganrajan.apps.coredomainprocessor.dto.Policy;
import com.saranganrajan.apps.coredomainprocessor.dto.PolicyPlan;
import com.saranganrajan.apps.coredomainprocessor.dto.PolicyStatus;
import com.saranganrajan.apps.coredomainprocessor.external.database.entity.CustomerPolicyEntity;
import com.saranganrajan.apps.coredomainprocessor.external.database.entity.PlanEntity;
import com.saranganrajan.apps.coredomainprocessor.external.database.entity.PolicyEntity;
import com.saranganrajan.apps.coredomainprocessor.external.database.entity.PolicyStatusEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PolicyMapper {
    public PolicyMapper INSTANCE = Mappers.getMapper( PolicyMapper.class );

    Policy policyEntityToDto(PolicyEntity policyEntity);
    PolicyEntity policyDtoToEntity(Policy policy);

    CustomerPolicy customerPolicyEntityToDto(CustomerPolicyEntity customerPolicyEntity);
    CustomerPolicyEntity customerPolicyDtoToEntity(CustomerPolicy customerPolicy);

    List<CustomerPolicy> customerPolicyEntitiesToDtos(List<CustomerPolicyEntity> customerPolicyEntities);

    PolicyStatus policyStatusEntityToDto(PolicyStatusEntity policyStatusEntity);
    PolicyStatusEntity policyStatusDtoToEntity(PolicyStatus policyStatus);

    PolicyPlan planEntityToDto(PlanEntity planEntity);
    PlanEntity planDtoToEntity(PolicyPlan policyPlan);

}
