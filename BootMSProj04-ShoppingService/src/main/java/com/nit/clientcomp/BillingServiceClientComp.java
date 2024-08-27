package com.nit.clientcomp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BillingServiceClientComp {
	
	@Autowired
    private LoadBalancerClient client;
    
    public String invokeDoPayment() {
        // Get ServiceInstance objects representing the Provider MS from Eureka server having less load factor
        ServiceInstance instance = client.choose("Billing-Service");
        
        // get Details from service instance
        String url = instance.getUri()+"/billing-api/payment";
        
        // get RestTemplate class obj
        RestTemplate template = new RestTemplate();
        
        // invoke the service of the Provider MS
        String result = template.getForObject(url, String.class);
        return result;
	}

}
