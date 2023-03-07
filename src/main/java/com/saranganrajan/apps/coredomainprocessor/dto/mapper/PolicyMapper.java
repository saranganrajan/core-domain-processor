package com.saranganrajan.apps.coredomainprocessor.dto.mapper;

import com.saranganrajan.apps.coredomainprocessor.dto.*;
import com.saranganrajan.apps.coredomainprocessor.external.database.entity.*;
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

    PolicyTransaction policyTransactionEntityToDto(PolicyTransactionEntity policyTransactionEntity);
    PolicyTransactionEntity policyTransactionDtoToEntity(PolicyTransaction policyTransaction);

}
