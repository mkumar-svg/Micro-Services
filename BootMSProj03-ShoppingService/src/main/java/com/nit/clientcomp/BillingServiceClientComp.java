package com.nit.clientcomp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.DiscoveryClient;

@Component
public class BillingServiceClientComp {
	
	@Autowired
    private DiscoveryClient client;
    
    public String invokeDoPayment() {
        // Get ServiceInstance objects representing the "Billing-Service" instances from the Eureka server
        List<ServiceInstance> instanceList = client.getInstances("Billing-Service");
        
        // u need to pick the service Instance manually
        ServiceInstance instance = instanceList.get(0);
        
        // get Details from service instance
        String url = instance.getUri()+"/billing-api/payment";
        
        // get RestTemplate class obj
        RestTemplate template = new RestTemplate();
        
        // invoke the service of the Provider MS
        String result = template.getForObject(url, String.class);
        return result;
	}

}
