package com.nit.clientcomp;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("Billing-Service")
public interface IBillingServiceClientComp {
	
	@GetMapping("/billing-api/payment")
    public String invokeDoPayment();
	
	@GetMapping("/billing-api/payment/{cardNo}")
    public String invokeDoPaymentWithCard(@PathVariable("cardNo") long cardNo);

}
