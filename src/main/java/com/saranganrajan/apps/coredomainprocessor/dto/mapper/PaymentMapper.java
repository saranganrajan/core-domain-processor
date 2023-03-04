package com.saranganrajan.apps.coredomainprocessor.dto.mapper;

import com.saranganrajan.apps.coredomainprocessor.dto.Agent;
import com.saranganrajan.apps.coredomainprocessor.dto.Customer;
import com.saranganrajan.apps.coredomainprocessor.dto.PaymentHistory;
import com.saranganrajan.apps.coredomainprocessor.dto.PaymentMode;
import com.saranganrajan.apps.coredomainprocessor.external.database.entity.AgentEntity;
import com.saranganrajan.apps.coredomainprocessor.external.database.entity.CustomerEntity;
import com.saranganrajan.apps.coredomainprocessor.external.database.entity.PaymentHistoryEntity;
import com.saranganrajan.apps.coredomainprocessor.external.database.entity.PaymentModeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentMapper {
    public PaymentMapper INSTANCE = Mappers.getMapper( PaymentMapper.class );

    PaymentMode paymentModeEntityToDto(PaymentModeEntity paymentModeEntity);
    PaymentModeEntity paymentModeDtoToEntity(PaymentMode paymentMode);

    PaymentHistory paymentHistoryEntityToDto(PaymentHistoryEntity paymentHistoryEntity);
    PaymentHistoryEntity paymentHistoryDtoToEntity(PaymentHistory paymentHistory);
}
