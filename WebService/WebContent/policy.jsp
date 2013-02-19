<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="edu.cmu.ebiz.task8.bean.RecommendedWebsitesBean"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<jsp:include page="header.jsp" />
<script>
    function click(url){
    	window.open(url);
    }
    </script>

<div class="row-fluid" style="min-width: 900px;">
			<div class="span12 searchbox" >
				<h5 class="lead">Search Business License and Permits Information</h5>
				<jsp:include page="error-list.jsp" />
				<div>
				<form class="form-inline" method="POST" action="policy.do" style="margin-left: 20px;">
				
				          <div class="input-prepend">
					 	  		<span class="add-on">State</span>
						  		<input type="text"  name="state" class="input" style="height: 20px;" placeholder="State" value="${form.state }">
						  </div>
 						  <span style="margin-left: 30px"></span>
 						  
						  <div class="input-prepend">
						  		<span class="add-on">City</span>
						  		<input type="text"  name="city" class="input" style="height: 20px;" placeholder="City" value="${form.city }">
						  </div>
						  <span style="margin-left: 30px"></span>
						  
 						  <select class="span4" name="businesstype">
							<option value = "General Business Licenses">General Business Licenses</option>
							<option value = "Auto Dealership">Auto Dealership</option>
							<option value = "Barber Shop">Barber Shop</option>
							<option value = "Beauty Salon">Beauty Salon</option>
							<option value = "Child Care Services">Child Care Services</option>
							<option value = "Construction Contractor">Construction Contractor</option>
							<option value = "Debt Collection Agency">Debt Collection Agency</option>
							<option value = "Electrician">Electrician</option>
							<option value = "Massage Therapist">Massage Therapist</option>
							<option value = "Plumber">Plumber</option>
							<option value = "Restaurant">Restaurant</option>
						  </select><!-- <hr> -->
						  
 						  <span style="margin-left: 20px"></span>
						  <button type="submit" class="btn"><i class="icon-search"></i>Search</button>
					</form>
					</div>
					
				</div>
				<c:choose>
					<c:when test="${empty policy}">
							
					</c:when>
					<c:otherwise>
					    	<div class="span12 searchbox" style="margin-left: 0px;" >
								<h5 class="lead">Business License Information of <b>${form.city }, ${form.state }</b></h5>
								<div class="row-fluid" style="margin-left: 20px">
						
									<table class="table table-bordered" style="width: 800px;" >
										<thead>
										<tr class="info" style="text-align: center;">
										<th style="text-align: left;">Title</th>
										<th style="text-align: left;">URL</th>
										<th style="text-align: left;">Description</th>
									</tr>
								</thead>
							<tbody>
								<c:forEach var="policy" items="${policy}">
									<%-- <ul>
										<li style="text-align: left;">${policy.title}</li>
										<li style="text-align: left;"><a href ="javascript:click('${policy.url}');">${policy.url}</a></li>
										<li style="text-align: left;">${policy.description}</li>
									</ul> --%>
									<tr>
										<td style="text-align: left;">${policy.title} </td>
										<td style="text-align: left;"><a href ="javascript:click('${policy.url}');">${policy.url}</a></td>
										<td style="text-align: left;">${policy.description} </td> 
									</tr>
								</c:forEach>
							</tbody>
						</table> 
								</div>
					</div>
					</c:otherwise>
					</c:choose>	
				
				
	</div>

<jsp:include page="footer.jsp" />