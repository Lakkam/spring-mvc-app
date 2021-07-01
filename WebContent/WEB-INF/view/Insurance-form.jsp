<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>
<title>Insurance Application Form</title>

<style>
.error{color:red"}
</style>

</head>

<body>

	<form:form action="launchInsurance" modelAttribute="InsurancePolicy">
	
		First name (*): <form:input path="firstName" />
		<form:errors path="firstName" cssClass="error"></form:errors>
		<br>
		<br>
	
		Last name: <form:input path="lastName" />
		<form:errors path="lastName" cssClass="error"></form:errors>

		<br>
		<br>
	
		States:
		
		<form:select path="state">
			<form:options items="${InsurancePolicy.stateOptions}" />
		</form:select>

		<br>
		<br>

		Insurance Type:
		
		Auto <form:radiobutton path="insuranceType" value="Auto" />
		Home <form:radiobutton path="insuranceType" value="Home" />
		Life <form:radiobutton path="insuranceType" value="Life" />
		MotorCycle <form:radiobutton path="insuranceType" value="MotorCycle" />

		<br>
		<br>

	
		Zip Code: <form:input path="zipCode" />
		<form:errors path="zipCode"></form:errors>

		<input type="submit" value="Submit" />

	</form:form>


</body>

</html>












