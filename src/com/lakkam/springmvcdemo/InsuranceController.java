package com.lakkam.springmvcdemo;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lakkam.springmvcdemo.context.SpringApplicationContext;
import com.lakkam.springmvcdemo.insurance.auto.AutoInsurance;

@Controller
public class InsuranceController {

	private static final String AUTOINSURANCETYPE = "Auto";
	private static final String AUTOPREMIUM = "autopremium";

	/*
	 * This method executes while binding the form data and we can mention any core
	 * generic logics like string trimmer
	 */
	@InitBinder
	public void initBinder(WebDataBinder webBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		webBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	/*
	 * A method to display view page based on request mapping. Spring always uses Model object to holds form attributes.
	 */
	@RequestMapping("/")
	public String displayInsurancePage(Model insuranceModel) {

		insuranceModel.addAttribute("InsurancePolicy", new InsurancePolicy());

		return "Insurance-form";
	}
	
	/*
	 * This method to show another page based on request mapping
	 * @Valid says that form data is eligible to validate
	 * @ModelAttribute("form-name") this gives the form object from model attribute whcih we added in base method
	 * BindingResult holds errors related information. If it has errors, we can perform related operation
	 */

	@RequestMapping("/launchInsurance")
	public String launchInsurance(@Valid @ModelAttribute("InsurancePolicy") InsurancePolicy insurancePolicy,
			BindingResult bindingResult, Model springPolicyModel) {

		System.out.println("Printing bindingResult : <<<<" + bindingResult);
		if (insurancePolicy != null) {
			System.out.println("Priting First Name from launchInsurance() : " + insurancePolicy.getFirstName());
		}
		if (bindingResult.hasErrors()) {

			return "Insurance-form";
		} else {
			String insuranceType = insurancePolicy.getInsuranceType();
			AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
					SpringApplicationContext.class);
			// ClassPathXmlApplicationContext applicationContext = new
			// ClassPathXmlApplicationContext(
			// "spring-mvc-app-servlet.xml");
			if (insuranceType.equalsIgnoreCase(InsuranceController.AUTOINSURANCETYPE)) {
				AutoInsurance autoInsurance = applicationContext.getBean("autoInsuranceController",
						AutoInsurance.class);
				springPolicyModel.addAttribute(InsuranceController.AUTOPREMIUM,
						autoInsurance.getAutoInsurancePremium(insurancePolicy));
			}
			applicationContext.close();
			return "auto-insurancepage";
		}
	}

}
