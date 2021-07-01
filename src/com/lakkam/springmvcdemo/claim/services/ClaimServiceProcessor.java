package com.lakkam.springmvcdemo.claim.services;

import org.springframework.stereotype.Service;

@Service
public class ClaimServiceProcessor implements ClaimService {

	@Override
	public String processClaim() {
		System.out.println(this.getClass().getSimpleName() + " : Processing Claim for Auto ");
		String claimAmount = "1000 USD";

		return claimAmount;
	}
}
