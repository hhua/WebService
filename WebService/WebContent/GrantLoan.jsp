<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="header.jsp" />
	
	<div class="row-fluid" >
			
			<div class="span12 searchbox" >
				<h5 class="lead">Business Loans and Grants</h5>
				<jsp:include page="error-list.jsp" />
					<form class="form-inline" method="POST" action="grantloan.do" style="margin-left: 20px;">
					 	   <label class="control-label" for="inputLoc">State</label>
					 	 <div class="input-prepend">
						  		
						 <select name="state">
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
 						  <span style="margin-left: 20px"></span>
						  <button type="submit" class="btn"><i class="icon-search"></i>Search</button>
					</form>
				</div>
				<div class="span11">	
					<c:choose>
						<c:when test="${ empty loansList }">
						</c:when>
						<c:otherwise>
						<table class="table table-striped">
								<thead>
									<tr class="info" style="text-align: center;">
										<th style="text-align: left;">Program</th>
										<th style="text-align: left; width: 250px">Agency</th>
										<th style="text-align: left; width: 400px;">Description</th>
										<th style="text-align: left;"></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="loans" items="${loansList}">
										<tr>
											<td style="text-align: left;">${loans.program} </td>
											<td style="text-align: left;">${loans.agency} </td>
											<td style="text-align: left;">${loans.description} </td>
											<td style="text-align: left;"><a href ="${loans.url}" class="btn" target="_blank">Visit</a></td> 
										</tr>
									</c:forEach>
								</tbody>
							</table>
							</c:otherwise>
						</c:choose>
			</div>
			</div>
			
  <jsp:include page="footer.jsp" />
  
