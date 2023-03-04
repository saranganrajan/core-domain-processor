package com.saranganrajan.apps.coredomainprocessor.service.agent;

import com.saranganrajan.apps.coredomainprocessor.external.database.entity.AgentEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AgentService {
    List<AgentEntity> getAgents();
    Optional<AgentEntity> getAgentById(String agentCode);
}
