package com.saranganrajan.apps.coredomainprocessor.dto.mapper;

import com.saranganrajan.apps.coredomainprocessor.dto.Agent;
import com.saranganrajan.apps.coredomainprocessor.dto.Customer;
import com.saranganrajan.apps.coredomainprocessor.external.database.entity.AgentEntity;
import com.saranganrajan.apps.coredomainprocessor.external.database.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerAgentMapper {
    public CustomerAgentMapper INSTANCE = Mappers.getMapper( CustomerAgentMapper.class );

    public Customer customerEntityToDto(CustomerEntity customerEntity);
    CustomerEntity customerDtoToEntity(Customer customerEntity);

    Agent agentEntityToDto(AgentEntity agentEntity);
    AgentEntity agentDtoToEntity(Agent agent);
}
