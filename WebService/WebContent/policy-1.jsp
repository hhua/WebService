<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="edu.cmu.ebiz.task8.bean.PolicyBean"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<jsp:include page="header.jsp" />
	<script>
    function click(url){
    	window.open(url);
    }
    </script>

	<div class="row-fluid">
			<div class="span12 searchbox" >
				<h5 class="lead">Search Business License and Permits Information</h5>
				<jsp:include page="error-list.jsp" />
				<div>
				<form class="form-inline" method="POST" action="policy.do" style="margin-left: 20px;">
						  <div class="input-prepend">
						  		<span class="add-on">City</span>
						  		<input type="text"  name="city" class="input" style="height: 20px;" placeholder="City" value="${form.city }">
						  </div>
						  <span style="margin-left: 20px"></span>
						  <div class="input-prepend">
					 	  		<span class="add-on">State</span>
						  		<input type="text"  name="state" class="input" style="height: 20px;" placeholder="State" value="${form.state }">
						  </div>
 						  <span style="margin-left: 20px"></span>
 						  
 						  <select class="span4">
							<option>General Business Licenses</option>
							<option>Auto Dealership</option>
							<option>Barber Shop</option>
							<option>Beauty Salon</option>
							<option>Child Care Services</option>
							<option>Construction Contractor</option>
							<option>Debt Collection Agency</option>
							<option>Electrician</option>
							<option>Massage Therapist</option>
							<option>Plumber</option>
							<option>Restaurant</option>
						  </select><hr>
 						<!--   <div class = "dropdown">
				  			<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu">
								<li><a tabindex="-1" href="#">General Business Licenses</a></li>
								<li><a tabindex="-1" href="#">Auto Dealership</a></li>
								<li><a tabindex="-1" href="#">Barber Shop</a></li>
								<li><a tabindex="-1" href="#">Beauty Salon</a></li>
								<li><a tabindex="-1" href="#">Child Care Services</a></li>
								<li><a tabindex="-1" href="#">Construction Contractor</a></li>
								<li><a tabindex="-1" href="#">Debt Collection Agency</a></li>
								<li><a tabindex="-1" href="#">Massage Therapist</a></li>
								<li><a tabindex="-1" href="#">Plumber</a></li>
								<li><a tabindex="-1" href="#">Plumber</a></li>
						    </ul>
						  </div>
						  <br> -->
 						  <span style="margin-top: 20px"></span>
						  <button type="submit" class="btn"><i class="icon-search"></i>Search</button>
					</form>
					</div>
					
					<div>
					</div>
				</div>
				
				<table class="table table-striped">
							<thead>
								<tr class="info" style="text-align: center;">
									<th style="text-align: left;">Title</th>
									<th style="text-align: left;">URL</th>
									<th style="text-align: left;">Description</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="others" items="${policy}">
									<tr>
										<td style="text-align: left;">${policy.title} </td>
										<td style="text-align: left;"><a href ="javascript:click('${policy.url}');">${policy.url}</a></td>
										<td style="text-align: left;">${policy.description} </td> 
									</tr>
								</c:forEach>
							</tbody>
						</table> 
				
	</div>

<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<body>
	<h4>License and Permits</h4>
	<form>
		<h5>Search by State or City</h5>
		<input class="span3" type="text" placeholder="State">
		<input class="span3" type="text" placeholder="City">
		<h5>Business Type</h5>
		<select class="span4">
			<option>General Business Licenses</option>
			<option>Auto Dealership</option>
			<option>Barber Shop</option>
			<option>Beauty Salon</option>
			<option>Child Care Services</option>
			<option>Construction Contractor</option>
			<option>Debt Collection Agency</option>
			<option>Electrician</option>
			<option>Massage Therapist</option>
			<option>Plumber</option>
			<option>Restaurant</option>
		</select></br>
		<button type="submit" class="btn">Submit</button>
	</form>
</body> -->



<jsp:include page="footer.jsp" />