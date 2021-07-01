package com.lakkam.springmvcdemo.insurance.auto;

import org.springframework.beans.factory.annotation.Autowired;

import com.lakkam.springmvcdemo.InsurancePolicy;
import com.lakkam.springmvcdemo.insurance.premium.PremiumService;

 
public interface AutoInsurance {
	

	public String getAutoInsurancePremium(InsurancePolicy insurancePolicyObject);

}
