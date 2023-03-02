package com.saranganrajan.apps.coredomainprocessor.service.agent;

import com.saranganrajan.apps.coredomainprocessor.external.database.entity.AgentEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AgentService {
    List<AgentEntity> getAgents();
}
