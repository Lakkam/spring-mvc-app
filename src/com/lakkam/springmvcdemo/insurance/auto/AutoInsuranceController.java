package com.lakkam.springmvcdemo.insurance.auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lakkam.springmvcdemo.InsurancePolicy;
import com.lakkam.springmvcdemo.claim.services.ClaimService;
import com.lakkam.springmvcdemo.insurance.premium.PremiumService;

@Controller
@RequestMapping("/auto")
public class AutoInsuranceController implements AutoInsurance {

	@Autowired
	PremiumService myPremiumService;
	
	@Autowired
	ClaimService claimService;
	
	String[] autoPolicyzipCodes = { "560100", "560094" };

	@Override
	public String getAutoInsurancePremium(InsurancePolicy insurancePolicyObject) {
		String zipCode = insurancePolicyObject.getZipCode();
		boolean isAutoPolicyZipCode = isZipCodeEligibleForAutoPolicy(zipCode);

		if (isAutoPolicyZipCode) {
			System.out.println("<<< ZipCode is verified and Eligible for AutoPolicy. Making call to premium calculations : ");
			return myPremiumService.calculatePremium();
		} else {
			return "0";
		}
	}

	private boolean isZipCodeEligibleForAutoPolicy(String zipCode) {

		System.out.println("<<< Inside isZipCodeEligibleForAutoPolicy() method : checking zipCode" + zipCode);
		boolean isAutoZipCode = false;
		for (String zipCodes : autoPolicyzipCodes) {
			if (zipCode.equalsIgnoreCase(zipCodes)) {
				isAutoZipCode = true;
				break;
			} else {
				isAutoZipCode = false;
			}
		}

		return isAutoZipCode;
	}
	
	@RequestMapping("/processAutoClaim")
	public String processAutoClaim(Model springPolicyModel) {
		System.out.println("Initiating Auto Claim Process : ");
		String autoClaimAmount = claimService.processClaim();
		springPolicyModel.addAttribute("autoClaimAmount", autoClaimAmount);
		return "auto-insurancepage";
	}

}
