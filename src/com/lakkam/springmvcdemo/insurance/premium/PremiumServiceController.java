package com.lakkam.springmvcdemo.insurance.premium;

import org.springframework.stereotype.Component;

@Component
public class PremiumServiceController implements PremiumService {
	
	@Override
	public String calculatePremium() {
		return "2000 USD";
	}

}
