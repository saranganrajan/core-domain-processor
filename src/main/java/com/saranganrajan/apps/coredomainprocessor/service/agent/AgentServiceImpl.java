package com.saranganrajan.apps.coredomainprocessor.service.agent;

import com.saranganrajan.apps.coredomainprocessor.external.database.entity.AgentEntity;
import com.saranganrajan.apps.coredomainprocessor.external.database.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AgentServiceImpl implements AgentService {

    @Autowired
    AgentRepository agentRepository;

    @Override
    public List<AgentEntity> getAgents() {
        return agentRepository.findAll();
    }
}
