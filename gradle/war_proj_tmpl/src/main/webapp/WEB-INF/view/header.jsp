<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
$(document).ready(function(){
	$("#logoutButton").click(function(){	
		location.replace('signoff.htm');
	});
});
</script>
	<div id="capper"></div>
	<div id="header">
		<a href="#"></a><!-- logo will be inserted here -->
		<c:if test="${account_header ne null}">
			<div id="lii_left_cust" style="margin-right:-4px;"><!-- Three Lines MAX! -->
				<div class="fieldnames">Company:<br />Account #:<br />Hierarchy:</div>
				<div class="fields">
					<div class="fieldvalues" id="company">${account_header.companyName}</div>
					<div class="fieldvalues" id="account">${account_number} [${account_header.legacySystem} ${account_header.legacyAccountNumber}]</div>
					<div class="fieldvalues" id="hierarchy">${account_header.accountHierarchy}</div>				
				</div>
			</div>
		</c:if>	
		<c:if test="${user ne null}">
			<div id="loginInfo">
				<div id="lii_left">
					<div id="welcome">User - </div>
					<div id="name">${user.firstName} ${user.lastName}</div><br/>
				</div>
	
				<div id="lii_right">
					<button type="button" class="logout" id="logoutButton">
						Log out</button>
				</div>
				<br />
			</div><!-- loginInfo -->
		</c:if>
<!-- 
			<div class="notificationBox" id="notificationBox"><h2>Alert: <a href="alertdetails.shtml">details</a></h2><div id="notification">The customer's credit card has expired. There is more to this</div></div>
 -->
		<br>
		
		</div><!-- header -->	
		
