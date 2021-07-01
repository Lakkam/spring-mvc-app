package com.lakkam.springmvcdemo;

import java.util.LinkedHashMap;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.lakkam.springmvcdemo.cusom.annotations.LastNameAnnotation;
import com.lakkam.springmvcdemo.cusom.annotations.ZipCode;

/*
 * It is a data object to hold form data
 */
public class InsurancePolicy {

	/*
	 * Regular validations can be enabled by using the below basic annotations for each field
	 */
	@NotNull(message="is Required")
	@Size(min=1, max=10, message="is Required")
	private String firstName;
	
	/*
	 * We can create custom annotation as well like below. Please refer LastNameAnnotation file for more details.
	 */
	@LastNameAnnotation
	private String lastName;
	private LinkedHashMap<String, String> stateOptions;

	/*
	 * This is a custom annotation for ZipCode. Please refer class file.
	 */
	@ZipCode
	private String zipCode;
	
	
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public LinkedHashMap<String, String> getStateOptions() {
		return stateOptions;
	}

	public void setStateOptions(LinkedHashMap<String, String> stateOptions) {
		this.stateOptions = stateOptions;
	}

	private String insuranceType;
	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public InsurancePolicy() {
		stateOptions = new LinkedHashMap<String, String>();
		stateOptions.put("AP", "Andhra");
		stateOptions.put("KA", "Karnataka");
		stateOptions.put("TN", "TamilNadu");
		stateOptions.put("KL", "Kerala");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

}
