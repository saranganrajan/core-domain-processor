package com.saranganrajan.apps.coredomainprocessor.external.domain.feign;

import com.saranganrajan.apps.coredomainprocessor.dto.PolicyAggregate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="core-domain-service", url="http://20.253.41.182:8082")
public interface DomainFeignClient {
    @PostMapping(path = "/domain/process", produces = "application/json")
    ResponseEntity<PolicyAggregate> processPolicyTransaction(@RequestBody PolicyAggregate policyAggregate);
}
