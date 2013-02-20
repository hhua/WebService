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
						  
						  <select name="state" >
							<option value="AL">Alabama</option>
							<option value="AK">Alaska</option>
							<option value="AZ">Arizona</option>
							<option value="AR">Arkansas</option>
							<option value="CA">California</option>
							<option value="CO">Colorado</option>
							<option value="CT">Connecticut</option>
							<option value="DE">Delaware</option>
							<option value="DC">District of Columbia</option>
							<option value="FL">Florida</option>
							<option value="GA">Georgia</option>
							<option value="HI">Hawaii</option>
							<option value="ID">Idaho</option>
							<option value="IL">Illinois</option>
							<option value="IN">Indiana</option>
							<option value="IA">Iowa</option>
							<option value="KS">Kansas</option>
							<option value="KY">Kentucky</option>
							<option value="LA">Louisiana</option>
							<option value="ME">Maine</option>
							<option value="MD">Maryland</option>
							<option value="MA">Massachusetts</option>
							<option value="MI">Michigan</option>
							<option value="MN">Minnesota</option>
							<option value="MS">Mississippi</option>
							<option value="MO">Missouri</option>
							<option value="MT">Montana</option>
							<option value="NE">Nebraska</option>
							<option value="NV">Nevada</option>
							<option value="NH">New Hampshire</option>
							<option value="NJ">New Jersey</option>
							<option value="NM">New Mexico</option>
							<option value="NY">New York</option>
							<option value="NC">North Carolina</option>
							<option value="ND">North Dakota</option>
							<option value="OH">Ohio</option>
							<option value="OK">Oklahoma</option>
							<option value="OR">Oregon</option>
							<option value="PA">Pennsylvania</option>
							<option value="RI">Rhode Island</option>
							<option value="SC">South Carolina</option>
							<option value="SD">South Dakota</option>
							<option value="TN">Tennessee</option>
							<option value="TX">Texas</option>
							<option value="UT">Utah</option>
							<option value="VT">Vermont</option>
							<option value="VA">Virginia</option>
							<option value="WA">Washington</option>
							<option value="WV">West Virginia</option>
							<option value="WI">Wisconsin</option>
							<option value="WY">Wyoming</option>
						</select>
						  </div>
 						  <span style="margin-left: 30px"></span>
 						  
						 
						  <span style="margin-left: 30px"></span>
						  
 						  <select class="span3" name="businesstype">
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
								<h5 class="lead">Business License Information of <b>${form.state }</b></h5>
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