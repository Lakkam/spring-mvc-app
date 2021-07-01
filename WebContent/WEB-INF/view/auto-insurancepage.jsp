<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<b>This is your Auto Insurance Page</b>
	<br /> Auto Insurance Premium is : ${autopremium}
	<br /> Entered Zip Code: ${InsurancePolicy.zipCode}
	<br />

	<a href="auto/processAutoClaim">Submit Auto Claim</a>

	<br />
	<b> Claim Amount for Auto Insurance : </b> ${autoClaimAmount}
</body>
</html>